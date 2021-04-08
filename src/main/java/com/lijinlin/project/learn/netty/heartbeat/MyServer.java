package com.lijinlin.project.learn.netty.heartbeat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class MyServer {
    public static void main(String[] args) throws Exception {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try{
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workerGroup)
                .channel(NioServerSocketChannel.class)
                //在bossGroup增加一个日志处理器
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        //1加入一个netty提供的IdleStateHandler：处理空闲状态的处理器
                        //2readerIdleTime:表示多长时间server没有读客户端的数据，就会发送一个心跳检测包，检测是否还是连接状态
                        //3writerIdleTime:表示多长时间server没有写数据给客户端，就会发送一个心跳检测包，检测是否还是连接状态
                        //4allIdleTime:表示多长时间server没有读写客户端数据，就会发送一个心跳检测包，检测是否还是连接状态
                        //5文档说明：* Triggers an {@link IdleStateEvent} when a {@link Channel} has not performed
                        // * read, write, or both operation for a while.
                        //6当IdleStateEvent触发后，就会传递给管道的下一个handler去处理，通过调用（触发）下一个handler
                        //的userEventTiggered,在该方法中去处理IdleStateEvent
                        pipeline.addLast(new IdleStateHandler(3,5,7, TimeUnit.SECONDS));

                        //加入一个对空闲检测进一步处理的自定义的handler
                        pipeline.addLast(null);
                    }
                });
            //启动服务器
            ChannelFuture channelFuture = serverBootstrap.bind(7000).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }


    }
}
