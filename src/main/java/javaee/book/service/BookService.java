package javaee.book.service;

import javaee.book.dao.BookDao;
import javaee.book.entity.BookBook;
import javaee.book.entity.BookBookReq;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class BookService {
    BookDao bookDao=new BookDao();
    public List<BookBook> selectAll()
    {
        return bookDao.selectAll();
    }
    public void insert(BookBook bookBook)
    {
        bookDao.insert(bookBook);
    }
    public List<BookBook>selectAnd(BookBookReq bookBookReq) {
        return bookDao.selectAnd(bookBookReq);
    }
}