package org.example.TByteBuffer;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Ivyevy
 * @description:
 */
@Slf4j
public class Demo {
    public static void main(String[] args) {
        /**
         * 获得FileChannel
         * 1.输入输出流 2.RandomAccessFile
         */

        try (FileInputStream inputStream = new FileInputStream("data.txt");
             FileChannel channel = inputStream.getChannel()) {
            // 获得ByteBuffer
            ByteBuffer buffer = ByteBuffer.allocate(10);
            while (true) {
                // 从channel读取数据, 写到buffer
                int len = channel.read(buffer);
                if (len == -1) {
                    break;
                }
                // 打印buffer的内容
                buffer.flip(); // buffer切换到读模式
                while (buffer.hasRemaining()) { // 检查buffer是否还有剩余未读数据
                    byte b = buffer.get();  // 字节对应ASCII码
                    log.debug("读取到的字符 {}, ", (char) b);
                }
                // 读完一次buffer切换为写模式
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
