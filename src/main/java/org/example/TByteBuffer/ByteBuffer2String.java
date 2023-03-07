package org.example.TByteBuffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static org.example.ByteBufferUtil.debugAll;

/**
 * @author Ivyevy
 * @description: 字符串bytebuffer互转
 */
public class ByteBuffer2String {
    public static void main(String[] args) {
        // 1.字符串直接转bytebuffer
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put("hello".getBytes());
        debugAll(buffer);

        // 2.charset,自动切换到读模式
        ByteBuffer buffer1 = StandardCharsets.UTF_8.encode("hello1");
        debugAll(buffer1);

        // 3.wrap,自动切换到读模式
        ByteBuffer buffer2 = ByteBuffer.wrap("liming".getBytes());
        debugAll(buffer2);
//********************************************************************
        // 1. charset,如果本身是读模式，需要先切换到读模式
        String s = StandardCharsets.UTF_8.decode(buffer1).toString();
        System.out.println(s);
        buffer.flip();
        String s1 = StandardCharsets.UTF_8.decode(buffer).toString();
        System.out.println(s1);
    }
}
