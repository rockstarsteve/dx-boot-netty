package com.dx.util;

/**
 * Description: string、hex相互转换工具
 * 1.
 * 在将字符串转为16进制之前先进行一次转化,先将其转化成为Unicode编码(相当于把中文用英文字符代替),在转化成为16进制
 * 2.
 * 相反的,在十六进制转换为字符串后的得到的是Unicode编码,此时再将Unicode编码解码即可获取原始字符串 字符串转16进制 /** * 字符串转换成为16进制(无需Unicode编码) *
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/10/6
 */
public class HexStringUtil {

    /**
     * 字符串转化成为16进制字符串
     *
     * @param string
     * @return
     */
    public static String string2HexString(String string) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = string.getBytes();
        int bit;
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
            //如果想看每个数据可以添加如下注释
            //sb.append(' ');
        }
        return sb.toString().trim();
    }

    /**
     * 16进制转换成为string字符串
     *
     * @param hexString
     * @return
     */
    public static String hexString2String(String hexString) {
        String str = "0123456789ABCDEF";
        char[] hexs = hexString.toCharArray();
        byte[] bytes = new byte[hexString.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
    }

    /**
     * 这个是参考：可以借鉴写法
     * 字符串转化成为16进制字符串（错误写法：没有切分，无法知道转换后是占用几个字节后进行相应的转换）
     * 这里是在java中把：字符强转int类型：是ascii码的编码；再把ascii码值转换为十六进制。所以配合着下面两个二进制转换一个字符是错误的
     * 要么用空格间隔，然后转换也可以
     *
     * @param string
     * @return
     */
    @Deprecated
    public static String string2HexStringError(String string) {
        String str = "";
        for (int i = 0; i < string.length(); i++) {
            int ch = (int) string.charAt(i);
            String s4 = Integer.toHexString(ch);
            str = str + s4;
        }
        return str;
    }

    /**
     * 这个是参考：可以借鉴写法
     * 16进制转换成为string类型字符串（错误写法：全部是两个二进制进行字符转换）
     *
     * @param string
     * @return
     */
    @Deprecated
    public static String hexString2StringError(String string) {
        if (string == null || string.equals("")) {
            return null;
        }
        string = string.replace(" ", "");
        byte[] baKeyword = new byte[string.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(string.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            string = new String(baKeyword, "UTF-8");
            new String();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return string;
    }

    public static void main(String[] args) {
        String str = "中国123,skf982013kjlkadfq]))*(*^!*&^*%#^%)!K";
        String byteString = HexStringUtil.string2HexString(str);
        System.out.println(byteString);
        System.out.println(HexStringUtil.hexString2String(byteString));
        /**
         * E4B8ADE59BBD3132332C736B663938323031336B6A6C6B616466715D29292A282A5E212A265E2A25235E2529214B
         *
         * E4 B8 AD E5 9B BD 31 32 33 2C 73 6B 66 39 38 32 30 31 33 6B 6A 6C 6B 61 64 66 71 5D 29 29 2A 28 2A 5E 21 2A 26 5E 2A 25 23 5E 25 29 21 4B
         */
        //字符串转化成为16进制字符串
        System.out.println(HexStringUtil.string2HexStringError(str));
        //16进制转换成为string类型字符串
        System.out.println(HexStringUtil.hexString2StringError(HexStringUtil.string2HexStringError(str)));
        /**
         * 4e2d56fd3132332c736b663938323031336b6a6c6b616466715d29292a282a5e212a265e2a25235e2529214b
         */
    }

}

