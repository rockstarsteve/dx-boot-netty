package com.dx.netty.websocket.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * Description: 继承ChannelInboundHandlerAdapter，从而不需要重写channelRead0方法
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/11/5
 */
public class HeartBeatHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

        //判断evt是否是IdleStateEvent（用于触发用户事件，包含读空闲、写空闲、读写空闲）
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.READER_IDLE) {
                System.out.println("进度读空闲。。。");
            } else if (event.state() == IdleState.WRITER_IDLE) {
                System.out.println("进度写空闲。。。。");
            } else if (event.state() == IdleState.ALL_IDLE) {
                //关闭无用的channel ,以防止资源浪费
                Channel channel = ctx.channel();
                System.out.println("连接用户的数量：" + CustomHandler.clients.size());
                System.out.println("关闭所有的内容");
                channel.close();
                System.out.println("连接用户的数量：" + CustomHandler.clients.size());
            }

        }
//        super.userEventTriggered(ctx, evt);
    }
}
