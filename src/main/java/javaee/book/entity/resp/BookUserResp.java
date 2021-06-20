package javaee.book.entity.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*纯粹的用户信息*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUserResp {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户类型:0admin;1user
     */
    private Integer userType;
}
