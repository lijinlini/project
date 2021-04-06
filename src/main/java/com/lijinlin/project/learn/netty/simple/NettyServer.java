package com.lijinlin.project.learn.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyServer {
    public static void main(String[] args)throws Exception {
        //创建BossGroup和WorkerGroup
        //1创建两个线程组 bossGroup和workerGroup
        //2bossGroup只处理连接请求，真正的客户端业务处理，会交给workerGroup完成
        //3两个都是无限循环
        //4bossGroup和workerGroup含有的子线程（NioEventLoop）的个数 默认是cpu核数 * 2
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try{
            //创建服务器端的启动对象，配置参数
            ServerBootstrap bootstrap = new ServerBootstrap();
            //使用链式编程进行设置,设置两个线程组
            bootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)//使用NioSocketChannel作为服务器的通道时间
                    .option(ChannelOption.SO_BACKLOG,128)//设置线程队列得到连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE,true)//设置保持活动连接状态
                   // .handler(null)//该handler对应bossGroup childHandler对应 workerGroup
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        //给pipeline设置处理器
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception{
                            System.out.println("客户socketchannel hashcode = " + ch.hashCode());
                            //可以使用一个集合管理SocketChannel,在推送消息时，可以将业务加入到各个channel对应的NIOEventLoop的
                            //taskQueue或者scheduleTaskQueue
                            ch.pipeline().addLast(new NettyServerHandler());
                        }
                    });//给我们的workerGroup的EventLopp对应的管道设置处理器
            System.out.println("......服务器 is ready...");
            //绑定一个端口并且同步，生成一个ChannelFuture对象
            ChannelFuture cf = bootstrap.bind(6668).sync();

            //给cf注册监听器，监控我们关心的事件
            cf.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if(cf.isSuccess()){
                        System.out.println("监听端口 6668 成功");
                    }else{
                        System.out.println("监听端口 6668 失败");
                    }
                }
            });

            //对关闭通道进行监听
            cf.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
