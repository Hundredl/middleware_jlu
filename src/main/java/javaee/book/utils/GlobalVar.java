package javaee.book.utils;

public class GlobalVar {
    public static enum userType{user,admin,none}
    public static userType getUserType(Integer userType)
    {
        switch (userType)
        {
            case 0:return GlobalVar.userType.admin;
            case 1:return GlobalVar.userType.user;
            default:return GlobalVar.userType.none;
        }
    }
}
