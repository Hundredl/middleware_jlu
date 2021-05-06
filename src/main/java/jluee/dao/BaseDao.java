package jluee.dao;

import java.sql.Connection;

/**
 * @author 吴非凡
 */
public class BaseDao {

    protected Connection conn;

    public BaseDao() {
        conn = DBUtil.getConnection();
    }
}
