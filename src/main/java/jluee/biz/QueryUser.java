//创建实现远程接口Bean类
package jluee.biz;

import jluee.dao.UserDao;
import jluee.entity.User;

import javax.ejb.Stateless;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author 吴非凡
 */
@Stateless
public class QueryUser implements QueryUserRemote {

    private final UserDao userDao;

    public QueryUser() {
        userDao = new UserDao();
    }

    @Override
    public byte[] queryUser(String username) {
        try {
            User user = userDao.getUserByName(username);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(user);
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
