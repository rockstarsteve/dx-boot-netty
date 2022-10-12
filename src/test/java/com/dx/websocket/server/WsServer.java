package com.dx.websocket.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Description: websocket服务
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/10/12
 */
public class WsServer {

    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup mainGroup = new NioEventLoopGroup();
        EventLoopGroup subGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap server = new ServerBootstrap();
            server
                    .group(mainGroup, subGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new WsServerInitializer());
            ChannelFuture channelFuture = server.bind(8070).sync();

            channelFuture.channel().closeFuture().sync();
        } finally {
            mainGroup.shutdownGracefully();
            subGroup.shutdownGracefully();
        }

    }

}
