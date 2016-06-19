package com.shifen.cloud.name.server.repository;

import java.util.List;

import com.shifen.cloud.name.common.entity.CloudHost;

/**
 * @author guofengzhao
 *
 */
public interface CloudHostDao {

  int insertBatch(List<CloudHost> list);
  int insert(CloudHost cloudHost);
  
  int deleteByPrimaryKey(long id);
  int deleteByIp(String ip);
  int deleteByHostname(String hostname);
  
  int updateByPrimaryKey(CloudHost host);
  int updateByIp(CloudHost host);
  int updateByHostname(CloudHost host);
  
  CloudHost selectByPrimaryKey(long id);
  CloudHost selectByHostname(String hostname);
  CloudHost selectByIp(String ip);
  
}
