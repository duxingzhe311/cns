package com.shifen.cloud.name.server.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

/**
 * 数据库主从 读写管理
 * @author ydl
 *
 */
public class SessionManager {
    private SqlSessionTemplate sqlWriteSession;
    private List<SqlSessionTemplate> sqlReadSessionList;
    private int readSessionCount = 0;
    public SqlSessionTemplate getSqlWriteSession() {
        return sqlWriteSession;
    }
    public void setSqlWriteSession(SqlSessionTemplate sqlWriteSession) {
        this.sqlWriteSession = sqlWriteSession;
    }
    public List<SqlSessionTemplate> getSqlReadSessionList() {
        return sqlReadSessionList;
    }
    public void setSqlReadSessionList(List<SqlSessionTemplate> sqlReadSessionList) {
        this.readSessionCount = sqlReadSessionList.size();
        this.sqlReadSessionList = sqlReadSessionList;
    }
    public int getReadSessionCount() {
        return readSessionCount;
    }
    
}
