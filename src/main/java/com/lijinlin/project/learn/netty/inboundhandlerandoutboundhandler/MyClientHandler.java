package com.lijinlin.project.learn.netty.inboundhandlerandoutboundhandler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class MyClientHandler extends SimpleChannelInboundHandler<Long> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
        System.out.println("服务器ip = "+ ctx.channel().remoteAddress() + "收到服务器消息 = " + msg);

    }
    //重写channelActive发送数据

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyClientHandler 发送数据");
        //ctx.writeAndFlush(Unpooled.copiedBuffer());
        //发送的是一个long
        ctx.writeAndFlush(123456L);
        //分析
        //1.abcdabcdabcdabcd是16个字节
        //2.该处理器的前一个handler是MyLongToByteEncode
        //3.MyLongToByteEncode父类是MessageToByteEncode
        //4.父类MessageToByteEncode io.netty.handler.codec.MessageToByteEncoder.write 会判断当前msg类型是不是应该处理的类型
        //如果不是就跳过encode方法
        /*public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        ByteBuf buf = null;
        try {
            if (acceptOutboundMessage(msg)) {
                @SuppressWarnings("unchecked")
                I cast = (I) msg;
                buf = allocateBuffer(ctx, cast, preferDirect);
                try {
                    encode(ctx, cast, buf);
                } finally {
                    ReferenceCountUtil.release(cast);
                }

                if (buf.isReadable()) {
                    ctx.write(buf, promise);
                } else {
                    buf.release();
                    ctx.write(Unpooled.EMPTY_BUFFER, promise);
                }
                buf = null;
            } else {
                ctx.write(msg, promise);
            }
        } catch (EncoderException e) {
            throw e;
        } catch (Throwable e) {
            throw new EncoderException(e);
        } finally {
            if (buf != null) {
                buf.release();
            }
        }
    }*/
        //5.因为我们编写Encoder时要注意传入的数据类型和处理的数据类型一致
        //ctx.writeAndFlush(Unpooled.copiedBuffer("abcdabcdabcdabcd",CharsetUtil.UTF_8));
    }
}
