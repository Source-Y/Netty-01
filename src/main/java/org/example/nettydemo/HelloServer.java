package org.example.nettydemo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author Ivyevy
 * @description:
 */
public class HelloServer {
    public static void main(String[] args) {
        // 1. 服务端启动器，负责组装Netty组件
        new ServerBootstrap()
                // 加入eventloop组，selector+thread就相当于一个eventloop，有的eventloop负责连接，有的负责read
                .group(new NioEventLoopGroup())
                // 选择一个serverSocketChannel的实现
                .channel(NioServerSocketChannel.class)
                // 小弟们负责做的事情
                .childHandler(
                        // 初始化负责服务端和客户端读写的channel
                        new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    // 负责添加别的处理器（处理器顺序执行），一个处理器相当于流水线的一道工序；pipeline().addLast：加入到流水线处理的最后面
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        // StringDecoder()处理器：将ByteBuf（Netty中的字节类型，类型ByteBuffer）转字符串
                        nioSocketChannel.pipeline().addLast(new StringDecoder());
                        nioSocketChannel.pipeline().addLast(
                                // 自定义的处理器，Inbound：处理客户端->服务端的数据，类似的有outbound
                                new ChannelInboundHandlerAdapter(){
                            @Override
                            // 处理读事件
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                System.out.println(msg);
                            }
                        });
                    }
                })
                .bind(8080);
    }
}
