package com.dx.tcpserve;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Socket 初始化器，每一个Channel进来都会调用这里的 InitChannel 方法
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/23
 */
@Component
public class SocketInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        // 添加对byte数组的编解码，netty提供了很多编解码器，你们可以根据需要选择
        pipeline.addLast(new ByteArrayDecoder());
        pipeline.addLast(new ByteArrayEncoder());
        // 添加上自己的处理器
        pipeline.addLast(new SocketHandler());
    }

}
