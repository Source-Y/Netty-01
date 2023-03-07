package org.example.TNio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.example.ByteBufferUtil.debugRead;

/**
 * @author Ivyevy
 * @description: Selector模式
 */
@Slf4j
public class SelectorServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ssc.bind(new InetSocketAddress(8999));
        // 1.创建Selector
        Selector selector = Selector.open();
        // 2.建立Selector与Channel的联系，获得事件和发生事件的channel
        SelectionKey sscKey = ssc.register(selector, 0, null);
        // 3.指明ssc只关注accept事件
        sscKey.interestOps(SelectionKey.OP_ACCEPT);
        log.debug("注册key:{}", sscKey);
        while (true) {
            selector.select();
            // 4. 获得事件集合
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                // SelectionKey事件处理后key不会自动移除，需要手动删除
                iterator.remove();
                log.debug("key:{}", key);
                if (key.isAcceptable()) {
                    // 5. 获得触发事件的channel
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    SocketChannel sc = channel.accept();
                    sc.configureBlocking(false);
                    log.debug("sc:{}", sc);
                    // 6. 关注读事件
                    SelectionKey scKey = sc.register(selector, 0, null);
                    scKey.interestOps(SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    try {
                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(16);
                        // 客户端正常/异常关闭会触发读事件，正常关闭read值为-1
                        int read = channel.read(buffer);
                        if (read == -1) {
                            key.channel();
                        }
                        buffer.flip();
                        debugRead(buffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                        // 客户端断开后，取消注册key
                        key.channel();
                    }
                }

            }
        }
    }
}
