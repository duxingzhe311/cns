package com.shifen.cloud.naming.server.repository;

import java.util.List;

import com.shifen.cloud.naming.common.entity.CloudInstance;

/**
 * @author guofengzhao
 *
 */
public interface CloudHostMapper {
  
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
  
}
