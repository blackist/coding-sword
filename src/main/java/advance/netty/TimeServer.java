package advance.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * TODO Netty Server
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/7/4
 */
public class TimeServer {

	public static void main(String[] args) {
		int port = 9800;
		new TimeServer().bind(port);
	}

	public void bind(final int port) {
		/**
		 * 配置服务端的 NIO 线程池,用于网络事件处理，实质上他们就是 Reactor 线程组
		 * bossGroup 用于服务端接受客户端连接，workerGroup 用于进行 SocketChannel 网络读写
		 */
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup();

		// ServerBootstrap 是 Netty 用于启动 NIO 服务端的辅助启动类，用于降低开发难度
		ServerBootstrap bootstrap = new ServerBootstrap();
		bootstrap.group(bossGroup, workGroup)
				.channel(NioServerSocketChannel.class)
				.option(ChannelOption.SO_BACKLOG, 1024)
				.childHandler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						/**
						 * 添加 LineBasedFrameDecoder 与 StringDecoder解码器
						 */
						ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
						ch.pipeline().addLast(new StringDecoder());
						ch.pipeline().addLast(new TimeServerHandler());
					}
				});

		try {
			ChannelFuture future = bootstrap.bind(port).sync();
			System.out.println(Thread.currentThread().getName() + ",服务器开始监听端口，等待客户端连接.........");

			future.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// 优雅退出
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}
}
