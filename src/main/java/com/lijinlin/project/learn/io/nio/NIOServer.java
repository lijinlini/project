package com.lijinlin.project.learn.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    public static void main(String[] args) throws Exception {
        //创建serverSocketChannel -> ServerSocket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //得到一个selector对象
        Selector selector = Selector.open();

        //绑定一个端口6666，在服务器端监听
        serverSocketChannel.socket().bind(new InetSocketAddress(6667));

        //设置为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //把serverSocketChannel 注册到selector 关心事件为OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("注册后的selectioneky数量=" + selector.keys().size());
        //循环等待客户端链接
        while (true) {
            //阻塞1秒钟 等于0就是没有事件发生(连接事件)
            if (selector.select(1000) == 0) {
                System.out.println("服务器等待了1秒，无链接");
                continue;
            }
            //1如果返回的是>0,表示已经获取到关注的事件了
            //2selector.selectedKeys()返回关注事件的集合
            //通过selectionKeys反向获取通道
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("selectionKeys数量=" + selectionKeys.size());
            //遍历selectionKeys，使用迭代器
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (keyIterator.hasNext()) {
                //获取到SelectKey
                SelectionKey key = keyIterator.next();
                //根据key 对应的通道发生的事件做相应处理
                if (key.isAcceptable()) {
                    //如果发生的是OP_ACCEPT这个事件：有新的客户端连接我
                    //给该客户端生成一个SocketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("客户端连接成功，生成了一个socketChannel = " + socketChannel.hashCode());
                    socketChannel.configureBlocking(false);
                    //将当前 socketChannel注册到selector,关注事件为OP_READ（读）
                    // 同时给socketChannel关联一个buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    System.out.println("客户端连接后，注册的selectionKey数量=" + selector.keys().size());
                }
                /*if (key.isReadable()) {
                    //发生OP_READ读事件
                    //通过key反向获取到对应channel
                    SocketChannel channel = (SocketChannel) key.channel();

                    //获取到该channel关联的buffer
                    ByteBuffer buffer = (ByteBuffer) key.attachment();

                    channel.read(buffer);
                    System.out.println("form客户端" + new String(buffer.array()));
                }*/
                if (key.isReadable()) {
                    //发生OP_READ读事件
                    //通过key反向获取到对应channel
                    SocketChannel channel = (SocketChannel) key.channel();
                    //运行读事件数据读取到Buffer中
                    channel.read(buffer);
                    String request = new String(buffer.array()).trim();
                    buffer.clear();
                    System.out.println("From client request" + request);
                    String response = "\r\n From server response" + request + "ok. \r\n\r\n";
                    channel.write(ByteBuffer.wrap(response.getBytes()));
                }

                //手动从集合中移除当前的selectionKey,防止重复操作
                keyIterator.remove();
            }
        }
    }
}
