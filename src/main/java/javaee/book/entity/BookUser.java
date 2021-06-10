package javaee.book.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
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
}

