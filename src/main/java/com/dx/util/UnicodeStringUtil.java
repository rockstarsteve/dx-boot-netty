package com.dx.util;

/**
 * Description: unicode、string 转换
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/10/7
 */
public class UnicodeStringUtil {

    /**
     * 字符串转换unicode
     */
    public static String string2Unicode(String string) {
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            // 取出每一个字符
            char c = string.charAt(i);
            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }
        return unicode.toString();
    }

    /**
     * unicode 转字符串
     */
    public static String unicode2String(String unicode) {
        StringBuffer string = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);
            // 追加成string
            string.append((char) data);
        }
        return string.toString();
    }



    public static void main(String[] args) {
        String str = "中国123,skf982013kjlkadfq]))*(*^!*&^*%#^%)!K";
        //字符串转换unicode
        System.out.println(UnicodeStringUtil.string2Unicode(str));
        //unicode 转字符串
        System.out.println(UnicodeStringUtil.unicode2String(UnicodeStringUtil.string2Unicode(str)));
        /**
         * （这里只能这样写，不然为非法的Unicode定义！！！）
         * "\\u4e2d\\u56fd\\u31\\u32\\u33\\u2c\\u73\\u6b\\u66\\u39\\u38\\u32\\u30\\u31\\u33\\u6b\\u6a\\u6c\\u6b\\u61\\u64\\u66\\u71\\u5d\\u29\\u29\\u2a\\u28\\u2a\\u5e\\u21\\u2a\\u26\\u5e\\u2a\\u25\\u23\\u5e\\u25\\u29\\u21\\u4b"
         * 中国123,skf982013kjlkadfq]))*(*^!*&^*%#^%)!K
         */
    }

}
