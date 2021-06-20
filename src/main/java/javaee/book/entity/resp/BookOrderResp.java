package javaee.book.entity.resp;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
/*纯粹的订单信息*/
public class BookOrderResp implements Serializable {

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
    List<BookSubOrderWithBook> subOrderList=new LinkedList<>();
    private static final long serialVersionUID = 1L;
}

