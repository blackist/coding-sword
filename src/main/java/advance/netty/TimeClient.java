package advance.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * TODO Netty Client
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/7/4
 */
public class TimeClient {

	public static void main(String[] args) {
		for (int i = 0; i < 1; i++) {
			new TimeThread().run();
		}
	}

	static class TimeThread extends Thread {
		@Override
		public void run() {
			connect("127.0.0.1", 9800);
		}

		public void connect(String host, int port) {
			EventLoopGroup group = new NioEventLoopGroup();
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(group).channel(NioSocketChannel.class)
					.option(ChannelOption.TCP_NODELAY, true)
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
							ch.pipeline().addLast(new StringDecoder());
							ch.pipeline().addLast(new TimeClientHandler());
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
	}


}
