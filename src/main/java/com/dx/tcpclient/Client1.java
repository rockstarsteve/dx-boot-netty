package com.dx.tcpclient;

import java.io.IOException;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/23
 */
public class Client1 {
    public static void main(String[] args) throws IOException {
        new ChatClient().start("李四");
    }
}
