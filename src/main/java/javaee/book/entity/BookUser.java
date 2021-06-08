package javaee.book.entity;

import lombok.Data;

@Data
public class BookUser {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户密码
     */
    private Integer password;

    /**
     * 用户类型:0admin;1user
     */
    private Integer userType;
}

