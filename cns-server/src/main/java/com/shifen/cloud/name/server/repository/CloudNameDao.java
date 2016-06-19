package com.shifen.cloud.name.server.repository;

import java.util.List;

import com.shifen.cloud.name.common.entity.CloudName;

/**
 * @author guofengzhao
 *
 */
public interface CloudNameDao {
  
  /**
   * get serviceName by id
   * @param id
   * @return
   */
  CloudName selectByPrimaryKey(long id);
  
  /**
   * add
   * @param list
   * @return
   */
  int insertBatch(List<CloudName> list);
  
  /**
   * delete
   * @param serviceName
   * @return
   */
  int deleteByPrimaryKey(CloudName serviceName);
  
  /** 
   * update
   * @param serviceName
   * @return
   */
  int updateByPrimaryKey(CloudName serviceName);
  
  
}
