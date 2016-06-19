package com.shifen.cloud.name.server.repository.host;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shifen.cloud.name.common.entity.CloudHost;
import com.shifen.cloud.name.server.repository.base.BaseDao;

/**
 * @author guofengzhao
 *
 */

@Repository
public class CloudHostDaoImpl extends BaseDao implements CloudHostDao {
  private static final String STATEMENT = "com.shifen.cloud.name.server.repository.mapper.CloudHostMapper.";

  @Override
  public int insertBatch(List<CloudHost> list) {
    return getSqlSession().insert(STATEMENT+"insertBatch", list);
  }

  @Override
  public int insert(CloudHost cloudHost) {
    return getSqlSession().insert(STATEMENT+"insert", cloudHost);
  }

  @Override
  public int deleteByPrimaryKey(long id) {
    return getSqlSession().delete(STATEMENT + "deleteByPrimaryKey", id);
  }

  @Override
  public int deleteByIp(String ip) {
    return getSqlSession().delete(STATEMENT + "deleteByIp", ip);
  }

  @Override
  public int deleteByHostname(String hostname) {
    return getSqlSession().delete(STATEMENT + "deleteByHostname", hostname);
  }

  @Override
  public int updateByPrimaryKey(CloudHost host) {
    return getSqlSession().update(STATEMENT + "updateByPrimaryKey", host);
  }

  @Override
  public int updateByIp(CloudHost host) {
    return getSqlSession().update(STATEMENT + "updateByIp", host);
  }

  @Override
  public int updateByHostname(CloudHost host) {
    return getSqlSession().update(STATEMENT + "updateByHostname", host);
  }

  @Override
  public CloudHost selectByPrimaryKey(long id) {
    return getSqlSession().selectOne(STATEMENT + "selectByPrimaryKey", id);
  }

  @Override
  public CloudHost selectByHostname(String hostname) {
    return getSqlSession().selectOne(STATEMENT + "selectByHostname", hostname);
  }

  @Override
  public CloudHost selectByIp(String ip) {
    return getSqlSession().selectOne(STATEMENT + "selectByIp", ip);
  }


}
