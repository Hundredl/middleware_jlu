package javaee.book.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BookUser {
    /**
     * 用户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户类型:0admin;1user
     */
    private Integer userType;

    @OneToMany(cascade = { CascadeType.ALL },mappedBy="user")
    private List<BookOrder> orderList;

    public BookUser(Integer userId, String userName, String password, Integer userType) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
    }
}

