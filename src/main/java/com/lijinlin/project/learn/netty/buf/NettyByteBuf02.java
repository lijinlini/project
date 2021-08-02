package com.lijinlin.project.learn.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

public class NettyByteBuf02 {
    public static void main(String[] args) {
        //创建ByteBuf
        ByteBuf byteBuf = Unpooled.copiedBuffer("hello,world!北京", Charset.forName("utf-8"));
        if (byteBuf.hasArray()) {
            byte[] content = byteBuf.array();
            //重新将content转成字符串
            System.out.println(new String(content, Charset.forName("utf-8")));
            System.out.println("byteBuf = " + byteBuf);

            //0
            System.out.println(byteBuf.arrayOffset());
            //0
            System.out.println(byteBuf.readerIndex());
            //18
            System.out.println(byteBuf.writerIndex());
            //36
            System.out.println(byteBuf.capacity());
            //len会减少1
            System.out.println(byteBuf.readByte());
            System.out.println(byteBuf.getByte(0));
            //可读的字节数18
            int len = byteBuf.readableBytes();
            System.out.println("len = " + len);
            //使用for取出各个字节
            for (int i = 0; i < len; i++) {
                //不加char输出的是ascii码
                System.out.println((char) byteBuf.getByte(i));
            }
            System.out.println(byteBuf.getCharSequence(12, 14, Charset.forName("utf-8")));
        }
    }
}
