package javaee.book.entity.resp;

import com.alibaba.fastjson.annotation.JSONField;
import javaee.book.entity.BookSubOrder;
import javaee.book.entity.BookUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/*订单和子订单信息，子订单信息包含图书*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookOrderWithSubOrder {
    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 配送地址
     */
    private String address;

    /**
     * 配送时间
     */
    @Temporal(TemporalType.DATE)
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date deliveryTime;

    /**
     * 收件人姓名
     */
    private String receiverName;

    /**
     * 电话
     */
    private String tel;

    /**
     * 总钱数
     */
    private Double total;

    /**
     * 子订单
     */
    private List<BookSubOrderWithBook> subOrderList= new ArrayList<>();


}
