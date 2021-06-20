package javaee.book.entity.resp;

import javaee.book.entity.BookBook;
import javaee.book.entity.BookOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
/*子订单信息，带有图书信息*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSubOrderWithBook {
    /**
     * 子订单id
     */
    private Integer subOrderId;


    /**
     * 图书
     */
    private BookBookResp book;

    /**
     * 个数
     */
    private Integer num;

    /**
     * 单价
     */
    private Double price;
}
