package com.dx.tcpserve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Description:
 * 监听Spring容器启动完成，完成后启动Netty服务器
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/23
 */
@Component
public class NettyStartListener implements ApplicationRunner {

    @Autowired
    private SocketServer socketServer;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.socketServer.start();
    }
}
