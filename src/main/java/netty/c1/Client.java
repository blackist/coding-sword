package netty.c1;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * TODO Netty Client
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/7/4
 */
public class Client {

	public static void main(String[] args) {
		for (int i = 0; i < 1; i++) {
			new TimeThread().setPort(9800).run();
			new TimeThread().setPort(9811).run();
		}
	}

	static class TimeThread extends Thread {

		private int port;

		@Override
		public void run() {
			connect("127.0.0.1", port);
		}

		public void connect(String host, int port) {
			EventLoopGroup group = new NioEventLoopGroup();
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(group).channel(NioSocketChannel.class)
					.option(ChannelOption.TCP_NODELAY, true)
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new ClientHandler());
						}
					});

			try {
				ChannelFuture future = bootstrap.connect(host, port).sync();
				future.channel().closeFuture().sync();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				group.shutdownGracefully();
			}
		}

		public TimeThread setPort(int port) {
			this.port = port;
			return this;
		}
	}
}
