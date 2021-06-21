package javaee.book.utils;

import org.apache.commons.beanutils.ConvertUtils;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author wyy
 * @version 1.0.0
 * @className: IsbnUtil
 * @Description ISBN编码校验工具类
 */
public class IsbnUtil {
    /**
     * 所需值
     */
    private static final String FORMAT_TEN = "^[0-9]{%s}[0-9X]{1}$";//十位的正则表达式
    private static final String FORMAT_THIRTEEN = "^[0-9]{%s}$";//十三位的正则表达式
    private static final Integer ZERO = 0;
    private static final Integer ONE = 1;
    private static final Integer TWO = 2;
    private static final Integer THREE = 3;
    private static final Integer NINE = 9;
    private static final Integer TEN = 10;
    private static final Integer ELEVEN = 11;
    private static final Integer THIRTEEN = 13;
    private static final String X = "X";

    /**
     * 校验 ISBN码是否正确
     * @param isbn 校验码的13位数字
     * @return 正确返回true ， 错误返回false
     */
    public static Boolean checkIsbn(String isbn) {
        //获取计算加权和所需要的值
        String substring = isbn.substring(ZERO, isbn.length() - ONE);
        //加权和S
        int s = ZERO;
        if (Pattern.matches(String.format(FORMAT_THIRTEEN, THIRTEEN), isbn)) {
            //获取比较值并转化为Integer
            Integer comparison = Integer.parseInt(isbn.substring(isbn.length() - 1));//校验码
            //转化为Integer数组
            //计算加权和：用1分别乘ISBN的前12位中的奇数位，用3乘以偶数位，然后将两者相加，即得到加权和
            for (int i = 0; i < substring.length(); i++) {
                int intNow=substring.charAt(i)-'0';
                s+=i%2==0? intNow :intNow*3;
            }
            //取余数M
            Integer m = s % TEN;
            //计算校验码N
            Integer N = TEN - m;
            return N.equals(TEN) ? comparison.equals(ZERO) : comparison.equals(N);
        }
        return false;
    }

    /**
     * @param isbnRaw isbn的13位数字
     * @return 正确返回格式化的校验码，错误返回null
     */
    public static String getIsbn13(String isbnRaw)
    {
        if (checkIsbn(isbnRaw))
        {
            return "ISBN "+isbnRaw.substring(0,3)+"-"+isbnRaw.substring(3,4)+"-"+isbnRaw.substring(4,8)+"-"+isbnRaw.substring(8,12)+"-"+isbnRaw.substring(12,13);
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(String.format("13位测试结果:%s", checkIsbn("9787115275790")));
        System.out.println(getIsbn13("9787115275790"));
    }
}
