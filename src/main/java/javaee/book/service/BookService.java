package javaee.book.service;

import book.IsbnVerify;
import book.IsbnVerifyProxy;
import javaee.book.dao.BookDao;
import javaee.book.entity.BookBook;
import javaee.book.entity.BookBookReq;

import javax.ejb.Stateless;
import java.rmi.RemoteException;
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

    /**
     * 验证isbnRaw是否位正确的，如果是正确的，将其变成 "ISBN xxx-x-xxxx-xxxx-x"的形式。
     * 调用webservice
     * @param isbnRaw 13位ISBN数字
     * @return 正确的ISBN码 / "wrong"
     */
    public String isbnVerify(String isbnRaw)
    {
        String isbn="wrong";
        try {
            IsbnVerify service = new IsbnVerifyProxy();
            isbn=service.isbnVerify("isbnRaw");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return isbn;
    }
}
