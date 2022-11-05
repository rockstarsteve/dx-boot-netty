package com.dx.netty.websocket.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.time.LocalTime;

/**
 * Description: 处理消息的handler
 * TextWebSocketFrame: 在netty中，是用于为websocket专门处理文本的对象，frame是消息的载体
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/10/12
 */
public class CustomHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    //用于管理所有的客户端
    public static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        //获取客户端传来的消息
        String text = msg.text();
        System.out.println("接收到的数据：" + text);

        //只发给当前来的人
        ctx.writeAndFlush("【服务器】接收到消息时间是：" + LocalTime.now() + " 接收到'" + ctx.channel().id().asShortText() + "'的消息为：" + text);

        //是否发送给全部用户的标识
        boolean sendAll = false;
        if (sendAll) {
            //迭代全部用户发送全部返回消息
            for (Channel client : clients) {
                /**
                 * 发送消息(下面两种都是)
                 */
                //client.writeAndFlush(msg);
                client.writeAndFlush(new TextWebSocketFrame("【服务器】接收到消息时间是：" + LocalTime.now() + " 接收到'" + ctx.channel().id().asShortText() + "'的消息为：" + text));
            }
            //这个方法和上面的for一致，发给全部
            //clients.writeAndFlush(new TextWebSocketFrame("【服务器】接收到消息时间是：" + LocalTime.now()) + " 接收到的消息为：" + text);
        }
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        clients.add(channel);
        System.out.println("添加channel.id().asLongText():" + channel.id().asLongText());
        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        clients.remove(channel);
        System.out.println("移除channel.id().asLongText():" + channel.id().asLongText());
        super.handlerRemoved(ctx);
    }
}
