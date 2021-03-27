package com.lijinlin.project.learn.io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel02 {
    public static void main(String[] args) throws Exception{
        File file = new File("d:\\file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        //通过 fileInputStream获取对应的FileChannel 实际类型 FileChannelImple
        FileChannel fileChannel = fileInputStream.getChannel();
        //创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());
        //将channel数据放入缓冲区
        fileChannel.read(byteBuffer);
        //将字节（byteBuffer）数据转成string
        System.out.println(new String(byteBuffer.array()));
        fileInputStream.close();
    }
}
