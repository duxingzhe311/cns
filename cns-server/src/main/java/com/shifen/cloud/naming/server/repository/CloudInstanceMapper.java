package com.shifen.cloud.naming.server.repository;

import java.util.List;

import com.shifen.cloud.naming.common.entity.CloudInstance;

/**
 * @author guofengzhao
 *
 */
public interface CloudInstanceMapper {
  
  // TODO 
  // 根据instance查询所属的service
  
  // TODO
  // 根据instance查询所属的host, ip
  
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
   * 删除instance
   * @param instance
   * @return
   */
  int deleteByPrimaryKey(CloudInstance instance);
}
