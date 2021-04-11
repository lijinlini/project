package com.lijinlin.project.learn.netty.inboundhandlerandoutboundhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MyLongToByteEncode extends MessageToByteEncoder<Long> {
    //编码的方法
    @Override
    protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("MyLongToByteEncode encode 被调用");
        System.out.println("msg = " + msg);
        out.writeLong(msg);
    }
}
