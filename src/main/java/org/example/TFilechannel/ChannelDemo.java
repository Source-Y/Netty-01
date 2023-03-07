package org.example.TFilechannel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @author Ivyevy
 * @description:
 */
public class ChannelDemo {
    public static void main(String[] args) {
        try (FileChannel from = new FileInputStream("data1.txt").getChannel();
             FileChannel to = new FileOutputStream("to.txt").getChannel()) {
            // 两个channel互送数据,单次上限2g
//            from.transferTo(0, from.size(), to);
            // 持续传输
            long size = from.size();
            for (long left = size; left > 0;) {
                left -= from.transferTo((size - left), left, to);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
