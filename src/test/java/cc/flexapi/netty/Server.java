package cc.flexapi.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author ckkk
 * @version 1.0
 * @description
 * @since 2026-04-17 12:12
 */
public class Server {

    static void main() throws InterruptedException {
        EventLoopGroup childLoopGroup = new NioEventLoopGroup();
        EventLoopGroup parentLoopGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(parentLoopGroup, childLoopGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<>() {
                        @Override
                        protected void initChannel(Channel channel) throws Exception {

                        }
                    });
            ChannelFuture channelFuture = serverBootstrap.bind("127.0.0.1", 8080);
            channelFuture.channel().closeFuture().sync();
        } finally {
            childLoopGroup.shutdownGracefully();
            parentLoopGroup.shutdownGracefully();
        }
    }
}
