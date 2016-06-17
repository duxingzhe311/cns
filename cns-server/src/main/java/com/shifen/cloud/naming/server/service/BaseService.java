package com.shifen.cloud.naming.server.service;

import java.util.List;

/**
 * @author guofengzhao
 *
 */
public interface BaseService<T> {
  int insert(T record);

  int update(T record);

  T queryById(Long id);

  int queryCountAll();

  int queryCount(String searchKey);

  List<T> queryAll(int curPage, int pageSize);

  List<T> queryBySearchKey(String orderBy, String searchKey, int curPage, int pageSize);

  int deleteById(Long id);

  int deleteMultiById(List<Long> list);
}
