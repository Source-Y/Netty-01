package org.example.TByteBuffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

import static org.example.ByteBufferUtil.debugAll;

/**
 * @author Ivyevy
 * @description: 分散读取,集中写入
 */
public class ScatterReadsDemo {
    public static void main(String[] args) {
//        // 1.分散读取
//        try (RandomAccessFile rw = new RandomAccessFile("data.txt", "rw");
//             FileChannel channel = rw.getChannel()) {
//            ByteBuffer b1 = ByteBuffer.allocate(3);
//            ByteBuffer b2 = ByteBuffer.allocate(3);
//            ByteBuffer b3 = ByteBuffer.allocate(5);
//            channel.read(new ByteBuffer[]{b1, b2, b3});
//            b1.flip();
//            b2.flip();
//            b3.flip();
//            debugAll(b1);
//            debugAll(b2);
//            debugAll(b3);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // 2.集中写入
        ByteBuffer b1 = StandardCharsets.UTF_8.encode("I");
        ByteBuffer b2 = StandardCharsets.UTF_8.encode("love");
        // 中文在utf-8中占3个字节，英文占一个字节
        ByteBuffer b3 = StandardCharsets.UTF_8.encode("修狗");
        try (FileChannel channel = new RandomAccessFile("data1.txt", "rw").getChannel()) {
            channel.write(new ByteBuffer[]{b1, b2, b3});
        } catch (IOException e) {
        }
    }
}
