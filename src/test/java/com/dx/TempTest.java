package com.dx;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/10/6
 */
public class TempTest {

    @Test
    public void tempTest() throws UnsupportedEncodingException {
        String str = "-42-48-71-6";
        String[] split = str.split("-");
        byte[] bytes;
        for (int i = 0; i < split.length; i++) {

        }

        //-28-72-83
        Byte aByte = new Byte("-28");
        Byte bByte = new Byte("-72");
        Byte cByte = new Byte("-83");
        byte[] temp = new byte[]{aByte,bByte,cByte};
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i]);
        }

        String tempStr = new String(temp);
        System.out.println(tempStr);

        System.out.println("==============================");
        String str2= "中国";
        byte[] bytes1 = str2.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < bytes1.length; i++) {
            System.out.println(String.valueOf(bytes1[i]));

        }
        System.out.println();


    }


}
