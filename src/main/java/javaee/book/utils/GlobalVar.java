package javaee.book.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalVar {
    public enum userType{user,admin,none}
    public static userType getUserType(Integer userType)
    {
        switch (userType)
        {
            case 0:return GlobalVar.userType.admin;
            case 1:return GlobalVar.userType.user;
            default:return GlobalVar.userType.none;
        }
    }
    public enum RespMsg{
        login_success,login_failure,//登录
        signup_success,signup_failure,//注册
        book_search_result,book_insert_success,book_select_and,//书籍查询
        book_insert_temporarily_select,book_insert_temporarily_save,book_insert_temporarily_invalid_option,book_insert_temporarily_update,//管理员添加书籍
        book_isbn_verify,//isbn验证
        book_order_insert_temp_success,book_order_insert_temp_save,book_order_insert_temp_save_failure,//订单
        book_order_select_by_user_id,//用户通过id查询订单
        book_order_select_by_book_id,
        wrong_param,//错误的参数
    }
}
