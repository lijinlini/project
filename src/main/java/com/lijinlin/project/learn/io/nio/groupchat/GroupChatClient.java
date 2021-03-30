package com.lijinlin.project.learn.io.nio.groupchat;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class GroupChatClient {
    //定义相关属性
    private final  String HOST = "127.0.0.1";
    private final int PORT = 6667;
    private Selector selector;
    private SocketChannel socketChannel;
    private String username;

    //构造器完成初始化工作
    public GroupChatClient() throws IOException {
        try{
            selector = Selector.open();
            //连接服务器
            socketChannel = socketChannel.open(new InetSocketAddress(HOST, PORT));
            //设置非阻塞
            socketChannel.configureBlocking(false);
            //将channel注册到selector
            socketChannel.register(selector, SelectionKey.OP_READ);
            //得到username
            username = socketChannel.getLocalAddress().toString().substring(1);
            System.out.println(username + "is Ok...");
        }catch (Exception e){
            System.out.println(e);
        }

    }

    //向服务器发送消息
    public void sendInfo(String info){
        info = username + "说" + info;
        try{
            socketChannel.write(ByteBuffer.wrap(info.getBytes()));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //读取从服务器端回复的消息
    public void readInfo(){
        try{
            //不写时间就会阻塞在这里
            int readChannels = selector.select();
            if(readChannels > 0){
                //有可以用的通道
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while(iterator.hasNext()){
                    //客户端可能有多通道，所以用while循环处理
                    SelectionKey key = iterator.next();
                    if(key.isReadable()){
                        //客户端考虑可读信息
                        SocketChannel sc = (SocketChannel)key.channel();
                        //得到一个Buffer
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        //把通道中的数据读到buffer中
                        sc.read(buffer);
                        String msg = new String(buffer.array());
                        System.out.println(msg.trim());
                    }
                }
                //删除当前的selectionKey,防止重复操作
                iterator.remove();
            }else{
                //System.out.println("没有可以用的通道。。。");

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args)throws Exception {
        //启动我们的客户端
        GroupChatClient chatClient = new GroupChatClient();
        //启动一个线程,每隔3秒读取从服务器端发送的数据
        new Thread(){
            public void run(){
                while(true){
                    chatClient.readInfo();
                    try{
                        Thread.currentThread().sleep(3000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        //发送数据给服务器端
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String msg = scanner.nextLine();
            chatClient.sendInfo(msg);
        }
    }
}
