package com.dx;

import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/10/7
 */
public class CharByteTest {

    @Test
    public void charTest() {
        System.out.println("--------------------中的字节--------------------");
        byte[] bytes = "中".getBytes();
        System.out.println("bytes.length:" + bytes.length);
        for (int i = 0; i < bytes.length; i++) {
            System.out.print(bytes[i]);
        }
        System.out.println("");
        System.out.println("--------------------a的字节--------------------");
        byte[] bytes2 = "a".getBytes();
        for (int i = 0; i < bytes2.length; i++) {
            System.out.print(bytes2[i]);
        }
        System.out.println("");
        System.out.println("--------------------a--------------------");
        //char是一个字节，byte是两个字节，如果强转，可能会损失精度
        char z1 = 'a';
        System.out.println(z1);
        byte zbyte1 = (byte) z1;
        System.out.println(zbyte1);

        System.out.println("-------------------中---------------------");
        //char是一个字节，byte是两个字节，如果强转，可能会损失精度
        char z = '中';
        System.out.println(z);
        byte zbyte = (byte) z;
        System.out.println(zbyte);


        /**
         * --------------------中的字节--------------------
         * bytes.length:3
         * -28-72-83
         * --------------------a的字节--------------------
         * 97
         * --------------------a--------------------
         * a
         * 97
         * -------------------中---------------------
         * 中
         * 45
         */

    }

}
