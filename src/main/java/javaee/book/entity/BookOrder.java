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
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookOrder implements Serializable {

    /**
     * 订单id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    /**
     * 配送地址
     */
    private String address;

    /**
     * 配送时间
     */
    @Temporal(TemporalType.DATE)
    @JSONField(format="yyyy-MM-ddTHH:mm:ss")
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

    @ManyToOne(cascade={CascadeType.REFRESH})
    @JoinColumn(name="userId")
    private BookUser user;//一个订单对应一个user

    /**
     * 子订单
     */
    @OneToMany(cascade = { CascadeType.ALL },mappedBy="bookOrder")
    private List<BookSubOrder> subOrderList= new ArrayList<>();

    public BookOrder(Integer orderId, String address, Date deliveryTime, String receiverName, String tel, Double total, BookUser user) {
        this.orderId = orderId;
        this.address = address;
        this.deliveryTime = deliveryTime;
        this.receiverName = receiverName;
        this.tel = tel;
        this.total = total;
        this.user = user;
    }

    private static final long serialVersionUID = 1L;
}

