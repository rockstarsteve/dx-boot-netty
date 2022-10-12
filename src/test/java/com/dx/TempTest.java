package com.dx;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

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


//        String str = null;
//        str = String.format("Hi,%s", "小超");
//        System.out.println(str);
//        str = String.format("Hi,%s %s %s", "小超", "是个", "大帅哥");
//        System.out.println(str);
//        System.out.printf("字母c的大写是：%c %n", 'C');
//        System.out.printf("布尔结果是：%b %n", "小超".equals("帅哥"));
//        System.out.printf("100的一半是：%d %n", 100 / 2);
//        System.out.printf("100的16进制数是：%x %n", 100);
//        System.out.printf("100的8进制数是：%o %n", 100);
//        System.out.printf("50元的书打8.5折扣是：%f 元%n", 50 * 0.85);
//        System.out.printf("上面价格的16进制数是：%a %n", 50 * 0.85);
//        System.out.printf("上面价格的指数表示：%e %n", 50 * 0.85);
//        System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50 * 0.85);
//        System.out.printf("上面的折扣是%d%% %n", 85);
//        System.out.printf("字母A的散列码是：%h %n", 'A');
//
//
//        Date date = new Date();
//        //c的使用
//        System.out.printf("全部日期和时间信息：%tc%n", date);
//        //f的使用
//        System.out.printf("年-月-日格式：%tF%n", date);
//        //d的使用
//        System.out.printf("月/日/年格式：%tD%n", date);
//        //r的使用
//        System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n", date);
//        //t的使用
//        System.out.printf("HH:MM:SS格式（24时制）：%tT%n", date);
//        //R的使用
//        System.out.printf("HH:MM格式（24时制）：%tR", date);

        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("Host Name: " + address.getHostName());
            System.out.println("Host Address: " + address.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }


}
