package javaee.book.entity.req;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBookReq {

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
     * 出版时间开始
     */
    @Temporal(TemporalType.DATE)
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date publishTimeBegin;
    /**
     * 出版时间结尾
     */
    @Temporal(TemporalType.DATE)
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date publishTimeEnd;

    /**
     * 最低价格
     */
    private Double priceLow;

    /**
     * 最高价格
     */
    private Double priceHigh;

    /**
     * 图书类别
     */
    private String category;

}
