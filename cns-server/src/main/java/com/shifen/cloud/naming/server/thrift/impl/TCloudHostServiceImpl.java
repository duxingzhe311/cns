package com.shifen.cloud.naming.server.thrift.impl;

import org.apache.thrift.TException;

import com.shifen.cloud.naming.common.thrift.define.TCloudHost;
import com.shifen.cloud.naming.common.thrift.exception.ThriftException;
import com.shifen.cloud.naming.common.thrift.service.TCloudHostService;
/**
 * @author guofengzhao
 *
 */
public class TCloudHostServiceImpl implements TCloudHostService.Iface {

  @Override
  public TCloudHost getByPrimaryKey(long id) throws ThriftException, TException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public TCloudHost getByIp(String ip) throws ThriftException, TException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int updateHost(TCloudHost host) throws ThriftException, TException {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int addHost(TCloudHost host) throws ThriftException, TException {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int deleteHost(TCloudHost host) throws ThriftException, TException {
    // TODO Auto-generated method stub
    return 0;
  }

}
