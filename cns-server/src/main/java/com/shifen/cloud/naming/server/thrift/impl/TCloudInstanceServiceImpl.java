package com.shifen.cloud.naming.server.thrift.impl;

import java.util.List;

import org.apache.thrift.TException;

import com.shifen.cloud.naming.common.thrift.define.TCloudInstance;
import com.shifen.cloud.naming.common.thrift.exception.ThriftException;
import com.shifen.cloud.naming.common.thrift.service.TCloudInstanceService;
/**
 * @author guofengzhao
 *
 */
public class TCloudInstanceServiceImpl implements TCloudInstanceService.Iface {

  @Override
  public List<TCloudInstance> getCloudInstanceByService(String serviceName) throws ThriftException,
      TException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<TCloudInstance> getCloudInstanceByHost(String host) throws ThriftException,
      TException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<TCloudInstance> getCloudInstanceByIp(String ip) throws ThriftException, TException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int updateInstance(TCloudInstance instance) throws ThriftException, TException {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int updateInstanceStatus(TCloudInstance instance, int status) throws ThriftException,
      TException {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int addInstance(TCloudInstance instance) throws ThriftException, TException {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int deleteInstance(TCloudInstance instance) throws ThriftException, TException {
    // TODO Auto-generated method stub
    return 0;
  }

}
