package com.lijinlin.project.learn.io.nio;

import java.nio.Buffer;
import java.nio.IntBuffer;
import java.nio.channels.Channel;

public class BasicBuffer {
    public static void main(String[] args) {
        //举例说明nio中缓冲区buffer的使用
        //创建一个Buffer,大小为5，即可以存放5个int
        IntBuffer intBuffer = IntBuffer.allocate(5);
        for(int i = 0;i < intBuffer.capacity();i++){
            intBuffer.put(i * 2);
        }
        //如何从buffer读取数
        //将buffer转换，读写切换
        intBuffer.flip();
        while(intBuffer.hasRemaining()){
            //get之后指针后移
            System.out.println(intBuffer.get());
        }
    }
}
