package com.dx.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * Description: 字符串、byte互相转换的工具
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/10/7
 */
public class ByteStringUtil {

    /**
     * 获取byte(utf-8)的String字符串数据，使用空格分割
     *
     * @param string
     * @return
     */
    public static String string2Utf8ByteString(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte aByte : string.getBytes(StandardCharsets.UTF_8)) {
            stringBuffer.append(String.valueOf(aByte) + " ");
        }
        return stringBuffer.toString();
    }

    /**
     * 获取string的数据从bytestring(utf-8)的空格分割的string中来
     *
     * @param byteString
     * @return
     */
    public static String utf8ByteString2String(String byteString) {
        String[] split = byteString.split(" ");
        byte[] bytes = new byte[split.length];
        for (int i = 0; i < split.length; i++) {
            bytes[i] = Byte.valueOf(split[i]);
        }
        return new String(bytes);
    }

    /**
     * 获取byte(Gbk)的String字符串数据，使用空格分割
     *
     * @param string
     * @return
     */
    public static String string2GbkByteString(String string) {
        StringBuilder stringBuffer = new StringBuilder("");
        try {
            for (byte aByte : string.getBytes("gbk")) {
                stringBuffer.append(String.valueOf(aByte) + " ");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    /**
     * 获取string的数据从bytestring(Gbk)的空格分割的string中来
     *
     * @param byteString
     * @return
     */
    public static String gbkByteString2String(String byteString) {
        String[] split = byteString.split(" ");
        byte[] bytes = new byte[split.length];
        for (int i = 0; i < split.length; i++) {
            bytes[i] = Byte.valueOf(split[i]);
        }
        try {
            return new String(bytes, "gbk");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println("===========================utf8==================================");
        String str = "中国123,skf982013kjlkadfq]))*(*^!*&^*%#^%)!K";
        String byteString = ByteStringUtil.string2Utf8ByteString(str);
        System.out.println(byteString);
        System.out.println(ByteStringUtil.utf8ByteString2String(byteString));

        System.out.println("===========================gbk==================================");
        String gbkByteString = ByteStringUtil.string2GbkByteString(str);
        System.out.println(gbkByteString);
        System.out.println(ByteStringUtil.gbkByteString2String(gbkByteString));
        /**
         * ===========================utf8==================================
         * -28 -72 -83 -27 -101 -67 49 50 51 44 115 107 102 57 56 50 48 49 51 107 106 108 107 97 100 102 113 93 41 41 42 40 42 94 33 42 38 94 42 37 35 94 37 41 33 75
         * 中国123,skf982013kjlkadfq]))*(*^!*&^*%#^%)!K
         * ===========================gbk==================================
         * -42 -48 -71 -6 49 50 51 44 115 107 102 57 56 50 48 49 51 107 106 108 107 97 100 102 113 93 41 41 42 40 42 94 33 42 38 94 42 37 35 94 37 41 33 75
         * 中国123,skf982013kjlkadfq]))*(*^!*&^*%#^%)!K
         */

    }

}
