package com.dx;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/10/5
 */
public class CharsetTest {

    @Test
    public void test() throws UnsupportedEncodingException {
        //默认为编辑器的编码规则为：utf8
        String str = new String("中国");
        System.out.println("=================UTF8===================");
        byte[] bytes = str.getBytes("UTF8");
        System.out.print("中国用utf8编码后的byte内容是：");
        //-28-72-83-27-101-67
        for (byte aByte : bytes) {
            System.out.print(aByte);
        }
        String s = new String(bytes);
        System.out.println("");
        System.out.println("中国用utf8转来转去的内容是：" + s);


        //为gbk编码
        System.out.println("\n=================gbk===================");
        byte[] gbks = "中国".getBytes("GBK");
        System.out.print("中国用gbk编码后的byte内容是：");
        //-42-48-71-6
        for (byte aByte : gbks) {
            System.out.print(aByte);
        }
        System.out.println("");
        String gbk = new String(gbks, "gbk");
        System.out.println("中国用gbk编码转来转去后的内容是：" + gbk);


        /**
         * =================UTF8===================
         * 中国用utf8编码后的byte内容是：-28-72-83-27-101-67
         * 中国用utf8转来转去的内容是：中国
         *
         * =================gbk===================
         * 中国用gbk编码后的byte内容是：-42-48-71-6
         * 中国用gbk编码转来转去后的内容是：中国
         */





    }

}
