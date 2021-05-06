package jluee.dao;

import jluee.entity.User;
import java.sql.*;


/**
 * @author 吴非凡
 */
public class UserDao extends BaseDao{

    public UserDao() {
        super();
    }

    public boolean validateLogin(String username, String password) {
        boolean canLogin = false;

        try {
            PreparedStatement ps = conn
                    .prepareStatement("select * from `user` where name=? and pass=?");
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            canLogin = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return canLogin;
    }

    public User getUserByName(String username) {
        User user = new User();
        try {
            PreparedStatement ps = conn
                    .prepareStatement("select * from `user` where name=?");
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user.setUserName(rs.getString("name"));
                user.setPassword(rs.getString("pass"));
                user.setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
