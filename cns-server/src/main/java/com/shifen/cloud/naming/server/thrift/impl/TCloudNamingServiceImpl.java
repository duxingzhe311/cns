package com.shifen.cloud.naming.server.thrift.impl;

import org.apache.thrift.TException;

import com.shifen.cloud.naming.common.thrift.define.TCloudName;
import com.shifen.cloud.naming.common.thrift.exception.ThriftException;
import com.shifen.cloud.naming.common.thrift.service.TCloudNameService;
/**
 * @author guofengzhao
 *
 */
public class TCloudNamingServiceImpl implements TCloudNameService.Iface{

  @Override
  public TCloudName getByPrimaryKey(long id) throws ThriftException, TException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int updateServiceName(TCloudName serviceName) throws ThriftException, TException {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int addServiceName(TCloudName serviceName) throws ThriftException, TException {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int deleteServiceName(TCloudName serviceName) throws ThriftException, TException {
    // TODO Auto-generated method stub
    return 0;
  }

}
