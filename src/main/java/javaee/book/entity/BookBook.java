package javaee.book.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.*;

@Data
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
}

