package com.shifen.cloud.name.server.repository.instance;

import java.util.List;

import com.shifen.cloud.name.common.entity.CloudInstance;

/**
 * @author guofengzhao
 *
 */
public interface CloudInstanceDao {
  
  /**
   * 根据service查询所有的instances
   * @param serviceName
   * @return
   */
  List<CloudInstance> selectInstanceByServiceName(String serviceName);
  
  /**
   * 根据host查询所有的instances
   * @param host
   * @return
   */
  List<CloudInstance> selectInstanceByHost(String host);
  
  /** 
   * 根据ip查询所有的instances
   * @param ip
   * @return
   */
  List<CloudInstance> selectInstanceByIp(String ip);
  
  /**
   * 根据主键查询instance
   * @param id
   * @return
   */
  CloudInstance selectByPrimaryKey(long id);
  
  /**
   * 批量插入instance
   * @param list
   * @return
   */
  int insertBatch(List<CloudInstance> list);
  
  /**
   * 更新instance信息
   * @param instance
   * @return
   */
  int updateByPrimaryKey(CloudInstance instance);
  
  /** 
   * 更新instance的状态
   * @param instance
   * @param status
   * @return
   */
  int updateStatusByPrimaryKey(CloudInstance instance, int status);
  
  /**
   * 删除instance
   * @param instance
   * @return
   */
  int deleteByPrimaryKey(CloudInstance instance);
}
