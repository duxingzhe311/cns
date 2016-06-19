package com.shifen.cloud.name.server.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shifen.cloud.name.common.entity.CloudInstance;
import com.shifen.cloud.name.server.service.CloudNameService;

/**
 * @author guofengzhao
 * naming service
 */

@Service
public class CloudNameServiceImpl implements CloudNameService {

  @Override
  public List<CloudInstance> getInstanceByService(String serviceName) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<CloudInstance> getInstanceByHost(String host) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int updateInstance(CloudInstance instance) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int addInstance(CloudInstance instance) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int deleteInstance(CloudInstance instance) {
    // TODO Auto-generated method stub
    return 0;
  }

}
