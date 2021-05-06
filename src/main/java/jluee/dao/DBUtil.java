package jluee.dao;

import jluee.client.MyContext;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 吴非凡
 */
public class DBUtil {

    private static Connection conn = null;

    public static Connection getConnection() {
        //if there is a connection already return it, otherwise establish one
        if (conn == null) {
            try {
                Context ctx = MyContext.getContext();
                Object datasourceRef = ctx.lookup("java:jboss/datasources/sampleDS");
                DataSource ds = (DataSource) datasourceRef;
                conn = ds.getConnection();
            } catch (SQLException | NamingException throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;

    }
}