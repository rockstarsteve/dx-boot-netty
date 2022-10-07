package com.dx;

import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/10/6
 */
public class String2IntTest {


    @Test
    public void tempTest() {
        String stringInt = "5";
        //这里jdk做的操作是：把int类型转换为string类型，然后进行拼接
        System.out.println(stringInt + 6);

        //这种情况就做不了
        //int total = stringInt + 6;

        System.out.println(Integer.parseInt("5") + 6);
    }

}
