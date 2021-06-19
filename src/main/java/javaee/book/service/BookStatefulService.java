package javaee.book.service;

import javaee.book.dao.BookDao;
import javaee.book.entity.BookBook;
import org.apache.commons.beanutils.BeanUtils;

import javax.ejb.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Stateful
@LocalBean
public class BookStatefulService{
    BookDao bookDao=new BookDao();
    Set<BookBook> ejbBookSet=new HashSet<>();
    public void insertSaveTemporarily(List<BookBook> bookList)
    {
        ejbBookSet.addAll(bookList);
    }
    public void insertSave()
    {
        bookDao.insertBatch(new LinkedList<BookBook>(ejbBookSet));
        ejbBookSet.clear();
    }
    public List<BookBook> getInsertSaveTemporarilyBookList()
    {
        List<BookBook> list=new LinkedList<>(ejbBookSet);
        return list;
    }

    /**
     * 替换全部书籍信息
     * @param bookList 书籍列表
     */
    public void update(List<BookBook> bookList)
    {
        ejbBookSet.clear();
        ejbBookSet.addAll(bookList);
    }

    /**
     * 替换相同id的书籍信息
     * @param bookBook 书籍列表
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void updateOne(BookBook bookBook) throws InvocationTargetException, IllegalAccessException {
        for (BookBook ejbBook:ejbBookSet)
        {
            if (ejbBook.getBookId().equals(bookBook.getBookId()))
            {
                BeanUtils.copyProperties(ejbBook,bookBook);
            }
            break;
        }
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
