package org.example.TByteBuffer;

import java.nio.ByteBuffer;

import static org.example.ByteBufferUtil.debugAll;

/**
 * @author Ivyevy
 * @description:
 */
public class BufferReadDemo {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a','b','c','d'});
        buffer.flip();

//        buffer.get(new byte[4]);
//        debugAll(buffer);
//        // 从头开始读
//        buffer.rewind();
//        System.out.println(((char) buffer.get()));

        // mark &reset
        // mark标记position位置，reset将position重置到mark位置
//        System.out.println(((char) buffer.get()));
//        System.out.println(((char) buffer.get()));
//        buffer.mark(); // position标记到2位置
//        System.out.println(((char) buffer.get()));
//        System.out.println(((char) buffer.get()));
//        buffer.reset(); // position跳到mark位置
//        System.out.println(((char) buffer.get()));
//        System.out.println(((char) buffer.get()));

        // geti：不会改变position
        System.out.println(((char) buffer.get(3)));
        debugAll(buffer);
    }
}
