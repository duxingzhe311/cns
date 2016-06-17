package com.shifen.cloud.naming.server.thrift;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import cn.px.zookeeper.configuration.BasicServerMetaManager;
import cn.px.zookeeper.configuration.IServerMetaManager;

import com.shifen.cloud.naming.common.annotation.ThriftServer;
import com.shifen.cloud.naming.common.utils.IpUtils;

@Component
public class ThriftServerContext
    implements
      InitializingBean,
      DisposableBean,
      ApplicationContextAware {
  private static final Logger logger = LoggerFactory.getLogger(ThriftServerContext.class);
  /**
   * 设置maxReadBuffer,否则阿里云端口扫描或者其他非法数据的端口访问 会导致thrift
   * server的maxReadBufferBytes被设置为long的最大值，诱发内存溢出Bug
   */
  private static final int MAX_READ_BUF_SIZE = 32 * 1024 * 1024;

  /* 端口 */
  @Value("${thrift.server.port}")
  private Integer port;

  /* zk ip */
  @Value("${zookeeper.ens.ip}")
  private String zkserverip;

  /* 节点名字 */
  @Value("${thrift.server.nodename}")
  private String nodename;

  @Value("${thrift.server.ip}")
  private String thriftIP;

  @Value("${thrift.server.port}")
  private Integer thriftPort;

  @Value("${zookeeper.ens.open}")
  private boolean open;

  private TServer server;

  private TMultiplexedProcessor processor;

  private ApplicationContext applicationContext;

  /**
   * 初始化Thrift，并启动
   */
  public void afterPropertiesSet() throws Exception {
    logger.info("the server is starting");
    // 初始化zk服务
    IServerMetaManager serverMetaManager = BasicServerMetaManager.getInstance();
    serverMetaManager.init(zkserverip);
    processor = new TMultiplexedProcessor();
    TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(this.port);
    TCompactProtocol.Factory profactory = new TCompactProtocol.Factory();
    TThreadedSelectorServer.Args tArgs = new TThreadedSelectorServer.Args(serverTransport);
    tArgs.processor(processor);
    tArgs.protocolFactory(profactory);
    // --设置maxReadBuffer,否则阿里云端口扫描或者其他非法数据的端口访问
    // --会导致thrift server的maxReadBufferBytes被设置为long的最大值，诱发内存溢出Bug
    tArgs.maxReadBufferBytes = MAX_READ_BUF_SIZE;
    tArgs.transportFactory(new TFramedTransport.Factory(MAX_READ_BUF_SIZE));
    server = new TThreadedSelectorServer(tArgs);
    // server.setServerEventHandler(new TrackingEventHandler());
    Map<String, Object> thriftMap = applicationContext.getBeansWithAnnotation(ThriftServer.class);
    for (Entry<String, Object> t : thriftMap.entrySet()) {
      Object obj = t.getValue();

      ThriftServer thriftServer = obj.getClass().getAnnotation(ThriftServer.class);
      String serviceName =
          StringUtils.isNotBlank(thriftServer.name()) ? thriftServer.name() : t.getKey();
      Class<?> clazz = thriftServer.processor();
      if (TProcessor.class.isAssignableFrom(clazz)) {
        Object processor = BeanUtils.instantiateClass(clazz.getConstructors()[0], obj);
        this.registerProcessor(serviceName, (TProcessor) processor);
        logger.info("Register Processor Interface[{}] OK", serviceName);
      } else {
        Class<?>[] interfaces = obj.getClass().getInterfaces();
        if (interfaces.length == 0) {
          logger.warn("Register Processor Interface[{}] Implements is Null, Skip", serviceName);
        } else {
          for (Class<?> iface : interfaces) {
            String cname = iface.getSimpleName();
            if (cname.equals("Iface")) {
              String pname = iface.getEnclosingClass().getName() + "$Processor";
              Class<?> pclass = this.applicationContext.getClassLoader().loadClass(pname);
              if (TProcessor.class.isAssignableFrom(pclass)) {
                Object processor = BeanUtils.instantiateClass(pclass.getConstructor(iface), obj);
                this.registerProcessor(serviceName, (TProcessor) processor);
                logger.info("Register Processor Interface[{}] OK", serviceName);
              } else {
                logger.warn("Register Processor Interface[{}] type error", serviceName);
              }
            }
          }
        }
      }
    }
    // 向zk注册服务，notename为节点名称,address为ip:port
    if (open) {
      serverMetaManager.register(nodename, IpUtils.getIP(thriftIP), thriftPort);
    }

    new ThriftThread().start();

    logger.info("the server is started and is listening at  {}:{}", this.thriftIP, this.port);
  }

  /**
   * 注册Thrift服务
   * 
   * @param serviceName
   * @param processor
   */
  public void registerProcessor(String serviceName, TProcessor processor) {
    this.processor.registerProcessor(serviceName, processor);
  }

  @Override
  public void destroy() throws Exception {
    server.stop();
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }

  private class ThriftThread extends Thread {
    @Override
    public void run() {
      server.serve();
    }
  }
}
