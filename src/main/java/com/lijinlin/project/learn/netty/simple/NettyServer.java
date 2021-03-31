package com.lijinlin.project.learn.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyServer {
    public static void main(String[] args)throws Exception {
        //创建BossGroup和WorkerGroup
        //1创建两个线程组 bossGroup和workerGroup
        //2bossGroup只处理连接请求，真正的客户端业务处理，会交给workerGroup完成
        //3两个都是无限循环
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        //创建服务器端的启动对象，配置参数
        ServerBootstrap bootstrap = new ServerBootstrap();
        //使用链式编程进行设置,设置两个线程组
        bootstrap.group(bossGroup,workerGroup)
                .channel(NioSocketChannel.class)//使用NioSocketChannel作为服务器的通道时间
                .option(ChannelOption.SO_BACKLOG,128)//设置线程队列得到连接个数
                .childOption(ChannelOption.SO_KEEPALIVE,true)//设置保持活动连接状态
                .childHandler();//给我们的workerGroup的EventLopp对应的管道设置处理器
    }
}
