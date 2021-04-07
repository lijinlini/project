package com.lijinlin.project.learn.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class NettyByteBuf01 {
    public static void main(String[] args) {
        //1创建对象ByteBuf该对象包含一个数组arr,是一个byte[10]
        //2在netty的buffer中，不需要使用flip进行反转，底层维护了readerIndex和writerIndex
        //3通过readerIndex和writerIndex和capacity,将buffer分成3个区
        //0-readerIndex:已经读取的区域
        //readerIndex-writerIndex:可读的区域
        //writerIndex-capacity:可写的区域
        ByteBuf buffer = Unpooled.buffer(10);
        for (int i = 0; i < 10; i++) {
            buffer.writeByte(i);
        }
        //10
        System.out.println("capacity = " + buffer.capacity());
        //输出 指定索引取不会影响readerIndex
        /*for (int i = 0; i < buffer.capacity(); i++) {
            System.out.println(buffer.getByte(i));
        }*/
        for (int i = 0; i < buffer.capacity(); i++) {
            System.out.println(buffer.readByte());
        }
        System.out.println("执行完毕");
    }
}
