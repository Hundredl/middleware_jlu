package javaee.book.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalVar {
    public enum RespMsg{
        success,
        failure,
        //wrong_param,//错误的参数
    }
    public static final String orderOutPath="./orders/";//订单输出的路径
}
