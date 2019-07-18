package netty.c2;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

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
							// 特殊分隔符
							ByteBuf buf = Unpooled.copiedBuffer("$_".getBytes());
							ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, buf));
							ch.pipeline().addLast(new StringDecoder());
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
