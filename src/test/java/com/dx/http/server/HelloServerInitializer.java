package com.dx.http.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * Description: 初始化器
 * channel注册后，会执行相依的初始化方法
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/10/11
 */
public class HelloServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        //通过channel去获取对应的管道
        ChannelPipeline pipeline = channel.pipeline();
        //通过管道添加handle，可以理解为连接器
        //当请求到服务器，我们准备要做对应的解码，响应到客户端做编码
        pipeline.addLast("HttpServerCodec", new HttpServerCodec());
        //添加自定义的助手类，来处理响应的内容
        pipeline.addLast("customHandler",new CustomHandler());
    }

}
