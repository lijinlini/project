package com.lijinlin.project.learn.netty.dubborpc.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

//需要用call方法所以实现callable
public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {
    //上下文
    private ChannelHandlerContext context;
    //返回的结果
    private String result;
    //客户端调用方法时，传入的参数
    private String para;
    //(1)与服务器的连接创建成功后，就会被调用
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(" channelActive 被调用");
        //因为我们在其他方法会使用到ctx
        context = ctx;
    }

    //(4)收到服务器的数据后，调用方法
    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(" channelRead 被调用");
        result = msg.toString();
        //唤醒等待的线程
        notify();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }


    //(3)被代理对象调用，发送数据给服务器，->wait -> 等待被唤醒(channelRead) ->返回结果(3)->5
    @Override
    public synchronized Object call() throws Exception {
        System.out.println(" call1 被调用");
        context.writeAndFlush(para);
        //进行wait,等待channelRead方法获取到服务器的结果后唤醒。
        wait();
        System.out.println(" call2 被调用");
        //服务方返回的结果
        return result;
    }
    //(2)
    void setPara(String para){
        System.out.println(" setPara 被调用");
        this.para = para;
    }
}
