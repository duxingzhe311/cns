package com.shifen.cloud.naming.server.repository;

import java.util.List;

import com.shifen.cloud.naming.common.entity.CloudInstance;

/**
 * @author guofengzhao
 *
 */
public interface CloudNameServiceMapper {
  /**
   * 根据service查询所有的instances
   * @param serviceName
   * @return
   */
  List<CloudInstance> selectInstanceByServiceName(String serviceName);
  
  
  
}
