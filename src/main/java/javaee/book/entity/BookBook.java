package javaee.book.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BookBook implements Serializable {
    /**
     * 图书id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    /**
     * 图书名称
     */
    private String name;

    /**
     * 图书书号
     */
    private String isbn;

    /**
     * 作者
     */
    private String author;

    /**
     * 出版时间
     */
    @Temporal(TemporalType.DATE)
    //@JSONField(format="yyyy-MM-dd HH:mm:ss.SSS")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date publishTime;

    /**
     * 价格
     */
    private Double price;

    /**
     * 图书类别
     */
    private String category;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 子订单
     */
    @OneToMany(cascade = { CascadeType.ALL },mappedBy="bookBook")
    private List<BookSubOrder> subOrderList= new ArrayList<>();

    public BookBook(Integer bookId, String name, String isbn, String author, Date publishTime, Double price, String category, Integer count) {
        this.bookId = bookId;
        this.name = name;
        this.isbn = isbn;
        this.author = author;
        this.publishTime = publishTime;
        this.price = price;
        this.category = category;
        this.count = count;
    }
}

