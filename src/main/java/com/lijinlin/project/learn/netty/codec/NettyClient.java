package com.lijinlin.project.learn.netty.codec;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufEncoder;

public class NettyClient {
    public static void main(String[] args) throws Exception {
        //客户端需要一个事件循环组
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            //创建客户端启动对象
            //注意客户端使用的不是ServerBootstrap而是Bootstrap
            Bootstrap bootstrap = new Bootstrap();
            //设置相关参数
            bootstrap.group(group)//设置线程组
                    .channel(NioSocketChannel.class)//设置客户端通道的实现类（反射）
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            //在pipelin中加入 ProtoBufEncoder
                            pipeline.addLast("encoder", new ProtobufEncoder());
                            //加入自己的处理器
                            pipeline.addLast(new NettyClientHandler());
                        }
                    });
            System.out.println("客户端 ok..");
            //启动客户端去连接服务器端
            //关于ChannelFuture要分析，涉及netty的异步模型
            ChannelFuture channelFutrue = bootstrap.connect("127.0.0.1", 6668).sync();
            //给关闭通道进行监听
            channelFutrue.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }

    }
}
