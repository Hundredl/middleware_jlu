package javaee.book.service;

import javaee.book.dao.UserDao;
import javaee.book.entity.BookUser;

public class UserService {
   UserDao userDao=new UserDao();
    public boolean canLoginIn(String userName,String password)
    {
        BookUser user=userDao.selectByUserName(userName);
        return user != null && password.equals(user.getPassword());
    }
    public BookUser selectByUserName(String userName)
    {
        return userDao.selectByUserName(userName);
    }
    public void add(BookUser bookUser)
    {
        userDao.selectById(bookUser);
    }
}
