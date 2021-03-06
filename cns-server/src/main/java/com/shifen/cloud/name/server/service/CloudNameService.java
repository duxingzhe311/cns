package com.shifen.cloud.name.server.service;

import java.util.List;

import com.shifen.cloud.name.common.entity.CloudInstance;

/**
 * @author guofengzhao
 *
 */
public interface CloudNameService {

  // get method
  List<CloudInstance> getInstanceByService(String serviceName);
  List<CloudInstance> getInstanceByHost(String host);
  
  // update
  int updateInstance(CloudInstance instance);
  
  // add 
  int addInstance(CloudInstance instance);
  
  // detele
  int deleteInstance(CloudInstance instance);
}
