package jluee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 吴非凡
 */
public class Test {

    public static void main(String[] args) {
        Connection conn = DBUtil.getConnection();
        if (conn != null) {
            System.out.println("Connection");

            try {
                PreparedStatement ps = conn
                        .prepareStatement("select * from `user` where name=? and pass=?");
                ps.setString(1, "Kevin");
                ps.setString(2, "123");

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    System.out.println("name: " + rs.getString("name"));
                    System.out.println("password: " + rs.getString("pass"));
                    System.out.println("role: " + rs.getString("role"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println(" No Connection");
        }
    }
}
