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
        login_success,login_failure,
        signup_success,signup_failure,
        book_search_result,book_insert_success,book_select_and}
}
