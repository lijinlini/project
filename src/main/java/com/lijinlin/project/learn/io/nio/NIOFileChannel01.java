package com.lijinlin.project.learn.io.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel01 {
    public static void main(String[] args) throws Exception {
        String str = "hello,李晋林";
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\file01.txt");
        //通过fileoutputStrem获取对应的filechannel
        //这个fileChannel 真实的类型是 FileChannelImpl
        FileChannel fileChannel = fileOutputStream.getChannel();

        //创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(str.getBytes());
        //对byteBuffer进行flip
        byteBuffer.flip();
        fileChannel.write(byteBuffer);
        fileOutputStream.close();
    }
}
