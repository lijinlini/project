package com.lijinlin.project.learn.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//BIO模型
public class BIOServer {
    //线程池机制
    //思路
    //1创建一个线程池
    //2如果有客户端连接就创建一个线程与之通讯（单独写一个方法）
    public static void main(String[] args) throws Exception {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        //创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动了");

        while (true) {
            //监听，等待客户端连接
            System.out.println("等待连接");
            //这里产生了阻塞！！
            final Socket socket = serverSocket.accept();
            System.out.println("链接到一个客户端");
            //就创建一个线程池，与之通讯（单独写一个方法）
            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    handler(socket);
                }
            });
        }
    }

    //编写一个handler方法，和客户端通讯
    public static void handler(Socket socket) {
        try {
            System.out.println("线程信息 id=" + Thread.currentThread().getId() +
                    "名字=" + Thread.currentThread().getName());
            byte[] bytes = new byte[1024];
            //通过socket获取一个输入流
            InputStream inputStream = socket.getInputStream();
            //循环读取客户端发送的数据
            while (true) {
                System.out.println("线程信息 id=" + Thread.currentThread().getId() +
                        "名字=" + Thread.currentThread().getName());
                System.out.println("read.....");
                //这里产生了阻塞！！
                int read = inputStream.read(bytes);
                if (read != 1) {
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("关闭和client的链接");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
