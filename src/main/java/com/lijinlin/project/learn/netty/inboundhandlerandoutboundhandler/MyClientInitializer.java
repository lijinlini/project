package com.lijinlin.project.learn.netty.inboundhandlerandoutboundhandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class MyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //在出站前，加入一个出站的handler，对数据进行一个编码
        pipeline.addLast(new MyLongToByteEncode());
        //这是一个入站的解码器
        //pipeline.addLast(new MyByteToLongDecoder());
        pipeline.addLast(new MyByteToLongDecoder2());
        //在加入一个自定义的handler，处理业务
        pipeline.addLast(new MyClientHandler());
    }
}
