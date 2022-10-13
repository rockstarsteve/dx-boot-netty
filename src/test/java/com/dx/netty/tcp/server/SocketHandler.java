package com.dx.netty.tcp.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 * Socket拦截器，用于处理客户端的行为
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/23
 */
@Slf4j
public class SocketHandler extends ChannelInboundHandlerAdapter {

    /**
     * 所有的连接
     */
    public static final ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 读取到客户端发来的消息
     *
     * @param ctx ChannelHandlerContext
     * @param msg msg
     * @throws Exception e
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 由于我们配置的是 字节数组 编解码器，所以这里取到的用户发来的数据是 byte数组
        byte[] data = (byte[]) msg;
        log.info("收到byte转String的数据: " + new String(data));
        System.out.print("收到byte数据: ");
        for (byte datum : data) {
            System.out.print(datum);
        }
        System.out.println();
        // 给其他人转发消息
        log.info("clients:", clients);
        for (Channel client : clients) {
            if (!client.equals(ctx.channel())) {
                client.writeAndFlush(data);
            }
        }
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        log.info("新的客户端链接：" + ctx.channel().id().asLongText());
        log.info("新的客户端链接：" + ctx.channel().remoteAddress());
        clients.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        log.info("客户端断开了连接：" + ctx.channel().id().asLongText());
        log.info("客户端断开了连接：" + ctx.channel().remoteAddress());
        clients.remove(ctx.channel());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable exception) throws Exception {
        //如果发生异常，打印异常，然后关闭这个连接
        exception.printStackTrace();
        ctx.channel().close();
        clients.remove(ctx.channel());
    }
}
