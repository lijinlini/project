package com.lijinlin.project.learn.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.util.CharsetUtil;

/**
 * 说明：
 * 1我们自定义一个Handler需要继承netty规定好的某个HandlerAdapter
 * 2这时我们定义一个Handler,才能称为一个Handler
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    //读取数据的事件(这里我们可以读取客户端发送的消息)
    /*
    1.ChannelHandlerContext ctx:上下文对象， 含有管道pipeline,通道channel,地址
    2.Object msg:就是客户端发送的数据 默认Object
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //比如这里我们有一个非常耗时的业务，需要进行异步执行，提交该channel对应的
        //NIOEventLoop的taskQueue中。
        //解决方案1：用户程序自定义的普通任务
        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10 * 1000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端,瞄2", CharsetUtil.UTF_8));
                } catch (Exception e) {
                    System.out.println("发生异常" + e.getMessage());
                }
            }
        });
        System.out.println("go on ...");


        /*System.out.println("服务器读取线程 " + Thread.currentThread().getName());
        System.out.println("server ctx = " + ctx);
        System.out.println("看看channel 和 pipeline的关系" + ctx);
        Channel channel = ctx.channel();
        //本质是一个双向链表，出栈，入栈问题
        ChannelPipeline pipeline = ctx.pipeline();
        //将 msg转成一个ByteBuf,这个ByteBuf是Netty提供的，不是NIO提供的，这里性能更高
        ByteBuf buf = (ByteBuf)msg;
        System.out.println("客户端发送消息是：" + buf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址" + ctx.channel().remoteAddress());*/
    }

    //数据读取完毕
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //super.channelReadComplete(ctx);
        //把数据写到缓存区，同时把数据刷新（从缓存区放到管道发送给客户端）
        //一般讲，我们对这个发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端，瞄1", CharsetUtil.UTF_8));
    }

    //处理异常，一般是需要关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}
