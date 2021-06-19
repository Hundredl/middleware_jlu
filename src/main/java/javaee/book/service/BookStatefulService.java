package javaee.book.service;

import javaee.book.dao.BookDao;
import javaee.book.entity.BookBook;

import javax.ejb.*;
import java.util.*;

@Stateful
@LocalBean
public class BookStatefulService{
    BookDao bookDao=new BookDao();
    Set<BookBook> ejbBookSet=new HashSet<>();
    public void insertSaveTemporarily(List<BookBook> bookList)
    {
        ejbBookSet.addAll(bookList);
        System.out.println(Arrays.toString(ejbBookSet.toArray()));
    }
    public void insertSave()
    {
        bookDao.insertBatch(new LinkedList<BookBook>(ejbBookSet));
        ejbBookSet.clear();
    }
    public List<BookBook> getInsertSaveTemporarilyBookList()
    {
        List<BookBook> list=new LinkedList<>(ejbBookSet);
        System.out.println("getInsertSaveTemporarilyBookList:"+list);
        return list;
    }
    @Remove
    public void remove()
    {
        System.out.println("remove");
    }
    @PrePassivate
    public void PrePassivate()
    {
        System.out.println("PrePassivate");
    }
}
