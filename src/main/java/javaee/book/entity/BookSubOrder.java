package javaee.book.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="BOOKSUBORDER")
public class BookSubOrder implements Serializable {
    /**
     * 子订单id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subOrderId;

    /**
     * 订单
     */
    @ManyToOne(cascade = { CascadeType.ALL },optional=false)
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private BookOrder bookOrder;

    /**
     * 图书
     */
    @ManyToOne(cascade = { CascadeType.ALL },optional=false)
    @JoinColumn(name = "bookId", referencedColumnName = "bookId")
    private BookBook bookBook;

    /**
     * 个数
     */
    private Integer num;

    /**
     * 单价
     */
    private Double price;

    private static final long serialVersionUID = 1L;
}

