package com.dx.netty.tcp.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Description: socket服务
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/23
 */
@Slf4j
@Component
public class SocketServer {


    public static void main(String[] args) {
        // bossGroup为接收请求的线程组，通俗的说就是“初始事件分发器”
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        // workerGroup实际工作的线程组，通俗的来说就是“事件处理器”
        NioEventLoopGroup workerGroup = new NioEventLoopGroup(1);

        // 两个线程组加入进来
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                //bossGroup负责接收连接，为每一个连接创建从线程，不仅接收也处理
                //workGroup负责接收许多客户端的读写操作，为每个请求创建处理线程，不仅接收也处理
                .group(bossGroup, workerGroup)
                // 配置为nio类型
                .channel(NioServerSocketChannel.class)
                // 加入自己的初始化器
                .childHandler(new SocketInitializer());
        serverBootstrap.bind(8070);
        log.info("Netty开启的端口: {} (TCP) boss线程{},work线程{}", 8070, 1, 1);
    }

}
