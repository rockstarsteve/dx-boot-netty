package com.dx.http.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/10/11
 */
public class HelloServer {

    public static void main(String[] args) throws InterruptedException {
        //定义一对线程组,
        //主线程组，用于接收客户端连接，不做任何处理
        EventLoopGroup bossgroup = new NioEventLoopGroup();
        //从线程组，主线程组把任务给工作线程组，让从线程组去完成相应的操作
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            //netty服务器的创建
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap
                    //把线程组设置到启动的类中
                    .group(bossgroup, workGroup)
                    //使用的io连接通道方式，这里使用nio
                    .channel(NioServerSocketChannel.class)
                    //子处理器，用于处理workgroup
                    .childHandler(new HelloServerInitializer())
            ;
            //设置启动的端口号，同时设置启动的方式为同步
            ChannelFuture channelFuture = serverBootstrap.bind(8070).sync();

            //监听关闭的channel，设置为同步方式
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossgroup.shutdownGracefully();
            bossgroup.shutdownGracefully();
        }
    }

}
