package org.example.TByteBuffer;

import java.nio.ByteBuffer;

import static org.example.ByteBufferUtil.debugAll;

/**
 * @author Ivyevy
 * @description:
 */
public class ReadWriteDemo {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte) 0x61); // 放入'a'字符
        debugAll(buffer);
        buffer.put(new byte[] {0x62, 0x63, 0x64}); //b,c,d
        debugAll(buffer);
        buffer.flip();
        System.out.println(buffer.get());
        debugAll(buffer);
        buffer.compact();
        debugAll(buffer);
        buffer.put(new byte[] {0x65, 0x66}); //e,f
        debugAll(buffer);
    }
}
