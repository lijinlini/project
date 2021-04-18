package com.lijinlin.project.learn.netty.dubborpc.netty;

import com.lijinlin.project.learn.netty.dubborpc.provider.HelloServiceImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

//服务器这边handler比较简单
public class NettyServerhandler extends ChannelInboundHandlerAdapter {
    private final String providerName = "HelloService#hello#";

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //获取发送的消息，并调用我们的服务
        System.out.println("msg" + msg);
        //客户端在调用服务器的api时,我们需要定义一个协议
        //比如我们要求每次发消息都必须以某个字符串开头 "HelloService#hello#XXX"
        if (msg.toString().startsWith(providerName)) {
            String result = new HelloServiceImpl().hello(msg.toString().substring(msg.toString().lastIndexOf("#") + 1));
            ctx.writeAndFlush(result);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
