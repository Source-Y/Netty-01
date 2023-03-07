package org.example.TByteBuffer;

import java.nio.ByteBuffer;

import static org.example.ByteBufferUtil.debugAll;

/**
 * @author Ivyevy
 * @description: 解决黏包半包
 */
public class Exam {
    public static void main(String[] args) {
        /**
         * \n 为分隔符
         * hello,world\nI'm zhangsan\nwh
         * o are you?\n
         * 转以下形式
         * hello,world\n
         * I'm zhangsan\n
         * who are you?\n
         */
        ByteBuffer buffer = ByteBuffer.allocate(32);
        buffer.put("hello,world\nI'm zhangsan\nwh".getBytes());
        splitS(buffer);
        buffer.put("o are you?\n".getBytes());
        splitS(buffer);
    }
    private static void splitS(ByteBuffer source) {
        // 切换读
        source.flip();
        for (int i = 0; i < source.limit(); i++) {
            if (source.get(i) == '\n') {
                int len = i + 1 - source.position();
                ByteBuffer target = ByteBuffer.allocate(len);
                for (int j = 0; j < len; j++) {
                    byte b = source.get();
                    target.put(b);
                }
                debugAll(target);
            }
        }
        // 继续写
        source.compact();
    }
}
