package com.lijinlin.project.learn.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel03 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(".\\src/main/java/com/lijinlin/project/learn/io/nio/1.txt");
        FileChannel fileChannel01 = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream(".\\src/main/java/com/lijinlin/project/learn/io/nio/2.txt");
        FileChannel fileChannel02 = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        while(true){
            /*
             position = 0;
        limit = capacity;
        mark = -1;
        return this;
             */
            byteBuffer.clear();
            int read = fileChannel01.read(byteBuffer);
            System.out.println(read);
            if(read == -1){
                break;
            }
            byteBuffer.flip();
            fileChannel02.write(byteBuffer);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
