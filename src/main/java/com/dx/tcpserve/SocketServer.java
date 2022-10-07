package com.dx.tcpserve;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/23
 */
@Slf4j
@Component
public class SocketServer {

    @Autowired
    private SocketInitializer socketInitializer;
    /**
     * 全局的server
     */
    private ServerBootstrap serverBootstrap;

    /**
     * netty服务监听端口
     */
    @Value("${netty.port:8070}")
    private int port;
    /**
     * 主线程组数量
     */
    @Value("${netty.bossThreadNum:1}")
    private int bossThreadNum;
    /**
     * 主线程组数量
     */
    @Value("${netty.workerThreadNum:1}")
    private int workerThreadNum;

    /**
     * 启动netty服务器
     */
    public void start() {
        this.init();
        this.serverBootstrap.bind(port);
        log.info("Netty开启的端口: {} (TCP) boss线程{}", port, bossThreadNum);
    }

    /**
     * 初始化netty配置
     */
    private void init() {
        // bossGroup为接收请求的线程组，通俗的说就是“初始事件分发器”
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(bossThreadNum);
        // workerGroup实际工作的线程组，通俗的来说就是“事件处理器”
        NioEventLoopGroup workerGroup = new NioEventLoopGroup(workerThreadNum);

        // 两个线程组加入进来
        this.serverBootstrap = new ServerBootstrap();
        this.serverBootstrap
                //bossGroup负责接收连接，为每一个连接创建从线程，不仅接收也处理
                //workGroup负责接收许多客户端的读写操作，为每个请求创建处理线程，不仅接收也处理
                .group(bossGroup, workerGroup)
                // 配置为nio类型
                .channel(NioServerSocketChannel.class)
                // 加入自己的初始化器
                .childHandler(this.socketInitializer);
    }
}
