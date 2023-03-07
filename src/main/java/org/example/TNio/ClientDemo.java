package org.example.TNio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @author Ivyevy
 * @description: 客户端
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("localhost", 8999));
        System.out.println("wait...");
        //sc.write(Charset.defaultCharset().encode("111"));
    }
}
