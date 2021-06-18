package javaee.book.entity;

import java.util.Date;
import lombok.Data;

@Data
public class BookBook {
    /**
     * 图书id
     */
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

