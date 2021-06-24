package javaee.book.entity.resp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
/*纯粹的书籍信息*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBookResp {
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
    @Temporal(TemporalType.DATE)
    //@JSONField(format="yyyy-MM-dd HH:mm:ss.SSS")
    @JSONField(format="yyyy-MM-dd")
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
