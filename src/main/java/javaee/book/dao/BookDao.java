package javaee.book.dao;

import javaee.book.entity.BookBook;
import javaee.book.entity.BookUser;
import javaee.book.entity.req.BookBookReq;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;


public class BookDao {
    private static final EntityManagerFactory emf;
    static {
        emf = Persistence.createEntityManagerFactory("jpaUnit");
    }
    public List<BookBook> selectAll()
    {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("select u from BookBook U");
        List<BookBook> result = query.getResultList();
        entityManager.close();
        return result;
    }
    public void insert(BookBook bookBook)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(bookBook);
        transaction.commit();
        em.close();
    }

    /**
     * 根据图书名称、书号、作者、出版时间范围、价格范围、类别查询
     * @param bookBookReq  查询条件
     * @return 查询结果
     */
    public List<BookBook> selectAnd(BookBookReq bookBookReq){
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createNativeQuery("select * from BOOKBOOK",BookBook.class);
        List<BookBook> resultRaw = query.getResultList();
        List<BookBook> result=new LinkedList<>();
        if (bookBookReq.getName().isEmpty())
        {
            bookBookReq.setName(null);
        }
        if (bookBookReq.getIsbn().isEmpty())
        {
            bookBookReq.setIsbn(null);
        }
        if (bookBookReq.getAuthor().isEmpty())
        {
            bookBookReq.setAuthor(null);
        }
        if (bookBookReq.getCategory().isEmpty())
        {
            bookBookReq.setCategory(null);
        }
        for (BookBook resultBook:resultRaw)
        {
            if (bookBookReq.getName()!=null&&resultBook.getName()!=null&&!(resultBook.getName().contains(bookBookReq.getName())))
            {
                continue;
            }
            if (bookBookReq.getIsbn()!=null&&resultBook.getIsbn()!=null&&!bookBookReq.getIsbn().equals(resultBook.getIsbn()))
            {
                continue;
            }
            if (bookBookReq.getAuthor()!=null&&resultBook.getAuthor()!=null&&bookBookReq.getAuthor().contains(resultBook.getAuthor()))
            {
                continue;
            }
            if (bookBookReq.getPublishTimeBegin()!=null&&resultBook.getPublishTime()!=null&&bookBookReq.getPublishTimeBegin().after(resultBook.getPublishTime()))
            {
                continue;
            }
            if (bookBookReq.getPublishTimeEnd()!=null&&resultBook.getPublishTime()!=null&&bookBookReq.getPublishTimeEnd().before(resultBook.getPublishTime()))
            {
                continue;
            }
            if (bookBookReq.getPriceLow()!=null&&resultBook.getPrice()!=null&& bookBookReq.getPriceLow().compareTo(resultBook.getPrice()) > 0)
            {
                continue;
            }
            if (bookBookReq.getPriceHigh()!=null&&resultBook.getPrice()!=null&& bookBookReq.getPriceHigh().compareTo(resultBook.getPrice()) < 0)
            {
                continue;
            }
            if (bookBookReq.getCategory()!=null&&resultBook.getCategory()!=null
                    &&!bookBookReq.getCategory().equals(resultBook.getCategory()))
            {
                continue;
            }
            result.add(resultBook);
        }
        return result;
    }

    public void insertBatch(List<BookBook> bookBookList)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        for (BookBook book:bookBookList)
        {
            em.persist(book);
        }
        transaction.commit();
        em.close();
    }

    public BookBook selectById(Integer bookId)
    {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createNativeQuery(String.format("select * from BOOKBOOK where bookId='%s'",bookId),BookBook.class);
        List<BookBook> result = query.getResultList();
        entityManager.close();
        if (result.size()==0)
        {
            return null;
        }
        else {
            return result.get(0);
        }
    }

    public void update(BookBook bookBook)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(bookBook);
        transaction.commit();
        em.close();
    }
    public void updateBatch(List<BookBook> bookList)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        for (BookBook book:bookList)
        {
            em.merge(book);
        }
        transaction.commit();
        em.close();
    }
}
