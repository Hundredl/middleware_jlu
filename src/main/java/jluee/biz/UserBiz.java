package jluee.biz;

import jluee.dao.UserDao;
import jluee.entity.User;

/**
 * @author 吴非凡
 */
public class UserBiz {
    private final UserDao userDao;

    public UserBiz() {
        userDao = new UserDao();
    }

    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }

    public boolean validateLogin(String username, String password) {
        return userDao.validateLogin(username, password);
    }
}
