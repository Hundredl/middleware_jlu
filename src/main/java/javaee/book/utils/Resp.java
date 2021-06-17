package javaee.book.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resp<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 返回内容
     */
    private T data;

}
