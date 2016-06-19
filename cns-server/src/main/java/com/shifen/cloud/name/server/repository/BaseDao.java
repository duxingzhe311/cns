package com.shifen.cloud.name.server.repository;

import java.util.Random;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao {
  @Autowired
  SqlSessionTemplate sqlWriteSession;
  @Autowired
  SessionManager sessionManager;
  private static final Logger log = LoggerFactory.getLogger(BaseDao.class);

  public SqlSessionTemplate getSqlSession() {
    try {
      StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
      String methodName = ste.getMethodName().toLowerCase();
      if (methodName.startsWith("select") || methodName.startsWith("get")) {
        if (sessionManager.getReadSessionCount() > 1) {
          return sessionManager.getSqlReadSessionList()
              .get(new Random().nextInt(sessionManager.getReadSessionCount()));
        } else {
          return sessionManager.getSqlReadSessionList().get(0);
        }
      }
      return sessionManager.getSqlWriteSession();
    } catch (Exception e) {
      log.error("获取数据库连接池异常！", e);
      return sqlWriteSession;
    }
  }
}
