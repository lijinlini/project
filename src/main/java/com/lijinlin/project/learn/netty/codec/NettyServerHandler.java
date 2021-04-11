package com.lijinlin.project.learn.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * 说明：
 * 1我们自定义一个Handler需要继承netty规定好的某个HandlerAdapter
 * 2这时我们定义一个Handler,才能称为一个Handler
 */
public class NettyServerHandler extends SimpleChannelInboundHandler<StudentPOJO.Student> {
    //读取数据的事件(这里我们可以读取客户端发送的消息)
    /*
    1.ChannelHandlerContext ctx:上下文对象， 含有管道pipeline,通道channel,地址
    2.Object msg:就是客户端发送的数据 默认Object
     */
    /*@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //读取从客户端发送的StudentPojo.Student
        StudentPOJO.Student student = (StudentPOJO.Student) msg;
        System.out.println("客户端发送的数据 id = " + student.getId() + "名字 = " + student.getName());
    }*/

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, StudentPOJO.Student msg) throws Exception {
        System.out.println("客户端发送的数据 id = " + msg.getId() + "名字 = " + msg.getName());
    }

    //数据读取完毕
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //super.channelReadComplete(ctx);
        //把数据写到缓存区，同时把数据刷新（从缓存区放到管道发送给客户端）
        //一般讲，我们对这个发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端喵1", CharsetUtil.UTF_8));
    }

    //处理异常，一般是需要关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}
