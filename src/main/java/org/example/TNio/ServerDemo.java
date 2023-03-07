package org.example.TNio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

import static org.example.ByteBufferUtil.debugRead;

/**
 * @author Ivyevy
 * @description: 服务端
 */
@Slf4j
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        // 1. 创建服务器
        ServerSocketChannel ssc = ServerSocketChannel.open();

        ssc.configureBlocking(false); // 配置为非阻塞模式

        // 2. 绑定监听端口
        ssc.bind(new InetSocketAddress(8999));
        // 3. 建立链接集合
        List<SocketChannel> channels = new ArrayList<>();
        while (true) {
            // 4. accept()建立与客户端的连接,socketChannel用于与客户端通讯
            SocketChannel socketChannel = ssc.accept();
            if (socketChannel != null) {
                log.debug("连接完成...{}", socketChannel);
                socketChannel.configureBlocking(false);
                channels.add(socketChannel);
            }
            for (SocketChannel channel : channels) {
                // 5. 接收客户端的数据
                channel.read(buffer);
                // 6. 打印
                buffer.flip();
                debugRead(buffer);
                buffer.clear();
                log.debug("读取完成...{}", channel);
            }
        }
    }
}
