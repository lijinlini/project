package com.lijinlin.project.learn.io.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 说明
 * 1MappedByteBuffer 可以让文件直接在内存（堆外内存）中修改，操作系统不需要拷贝一次
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile(".\\src/main/java/com/lijinlin/project/learn/io/nio/1.txt", "rw");
        //获取对应的文件通道
        FileChannel channel = randomAccessFile.getChannel();
        /*
        参数1：FileChannel.MapModel.Read_Write使用的读写模式
        参数2：0代表可以直接修改的起始位置
        参数3：映射到内存的大小（把1.txt的多少个字节映射到内存中，可以直接修改的范围就是0到5）
         */
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        //位置0改成H
        mappedByteBuffer.put(0, (byte) 'H');
        mappedByteBuffer.put(3, (byte) '9');
        mappedByteBuffer.put(4, (byte) 'Z');
    }
}
