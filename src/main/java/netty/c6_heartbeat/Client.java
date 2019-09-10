package netty.c6_heartbeat;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

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
		final ClientThread server = new ClientThread().setPort(9800).setHost("127.0.0.1");
		server.run();
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				server.send();
			}
		}, 4000, 4000);
	}

	static class ClientThread extends Thread {

		private String host;
		private int port;

		private AtomicInteger atomicInteger = new AtomicInteger();

		private ChannelFuture channelFuture;

		@Override
		public void run() {
			send();
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
							ch.pipeline().addLast(MarshallingCodeFactory.getDecoder());
							ch.pipeline().addLast(MarshallingCodeFactory.getEncoder());
							// ch.pipeline().addLast(new ReadTimeoutHandler(5));
							ClientHeartBeatHandler handler = new ClientHeartBeatHandler();
							handler.setClientThread(ClientThread.this);
							ch.pipeline().addLast(handler);
						}
					});

			try {
				channelFuture = bootstrap.connect(host, port).sync();

				channelFuture.channel().closeFuture().sync();
				System.out.println("Connection closed!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				group.shutdownGracefully();
			}
		}

		public void send() {
			if (channelFuture == null) {
				connect(host, port);
				return;
			} else if (!channelFuture.channel().isActive()) {
				connect(host, port);
				return;
			} else {
				if (atomicInteger.get() >4) {
					atomicInteger.set(0);
					return;
				}
				ReqInfo reqInfo = new ReqInfo();
				channelFuture.channel().writeAndFlush(reqInfo);
			}
		}

		public ClientThread setPort(int port) {
			this.port = port;
			return this;
		}

		public ClientThread setHost(String host) {
			this.host = host;
			return this;
		}

		public AtomicInteger getAtomicInteger() {
			return atomicInteger;
		}
	}
}
