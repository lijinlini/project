package com.lijinlin.project.learn.io.nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class GroupChatServer {

    //定义属性
    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int PORT = 6667;

    //构造器
    //初始化工作
    public GroupChatServer() {
        try {
            //得到选择器
            selector = Selector.open();
            //ServerSocketChannel
            listenChannel = ServerSocketChannel.open();
            //绑定端口
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            //设置非阻塞模式
            listenChannel.configureBlocking(false);
            //将该listenChannel注册到selecotr
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //监听
    public void listen() {
        try {
            while (true) {
                int count = selector.select(2000);
                if (count > 0) {
                    //有事件要处理
                    //遍历得到selectionKey集合
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while(iterator.hasNext()){
                        //取出selectionkey
                        SelectionKey key = iterator.next();
                        //如果监听到accept(连接事件)
                        if(key.isAcceptable()){
                            SocketChannel sc = listenChannel.accept();
                            //将sc注册到seletor
                            sc.register(selector,SelectionKey.OP_READ);
                            //提示
                            System.out.println(sc.getRemoteAddress()+"上线");
                        }
                        if(key.isReadable()){
                            //通道发生read事件，即通道是可读的状态
                            //处理读（专门写方法。。。）
                        }
                        //当前的key 删除 防止重复处理
                        iterator.remove();
                    }

                }else{
                    System.out.println("等待。。。");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
