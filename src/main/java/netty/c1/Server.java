package netty.c1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * TODO Netty Server
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/7/4
 */
public class Server {

	public static void main(String[] args) {
		int port = 9800;
		int port2 = 9811;
		new Server().bind(port);
		new Server().bind(port2);
		// 当前线程被netty阻塞
		for (int i = 0; i < 10; i++) {
			System.out.println("Run" + i);
		}
	}

	public void bind(final int port) {
		/**
		 * 配置服务端的 NIO 线程池,用于网络事件处理，实质上他们就是 Reactor 线程组
		 * bossGroup 用于服务端接受客户端连接，workerGroup 用于进行 SocketChannel 网络读写
		 */
		/**
		 * 通常一个服务端口即一个ServerSocketChannel对应一个Selector和一个EventLoop线程，建议BossEventLoopGroup的线程数参数这是为1;
		 * BossEventLoop负责接收客户端的连接并将SocketChannel交给WorkerEventLoopGroup来进行IO处理;
		 */
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup(3);

		// ServerBootstrap 是 Netty 用于启动 NIO 服务端的辅助启动类，用于降低开发难度
		ServerBootstrap bootstrap = new ServerBootstrap();
		bootstrap.group(bossGroup, workGroup)
				// 指定NIO模式
				.channel(NioServerSocketChannel.class)
				// TCP缓冲区
				.option(ChannelOption.SO_BACKLOG, 1024)
				.option(ChannelOption.SO_SNDBUF, 32 * 1024)
				.option(ChannelOption.SO_RCVBUF, 32 * 1024)
				// 保持连接
				.option(ChannelOption.SO_KEEPALIVE, true)
				.childHandler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						// 每个Client(被处理成SocketChannel)进来都处理一次
						// BossEventLoopGroup next()的单线程EventLoop(Reactor中的分离器) 分离IO事件 为 SelectionKey 交给 WorkerEventLoopGroup
						// SelectionKey(Reactor中的资源) 关联-> SocketChannel
						// WorkerEventLoopGroup(Reactor中的分发器) next() 将SocketChannel注册到一个EventLoop的Selector中
						// Channel持有ChannelPipeline, ChannelPipeline(Reactor中的处理器)维护着一个ChannelHandler链表队列
						System.out.println("SocketChannel coming...");
						ch.pipeline().addLast(new ServerHandler());
					}
				});

		try {
			ChannelFuture future = bootstrap.bind(9800).sync();
			System.out.println(Thread.currentThread().getName() + ",服务器开始监听端口，等待客户端连接.........");

			ChannelFuture future1 = bootstrap.bind(9811).sync();
			System.out.println(Thread.currentThread().getName() + ",服务器开始监听端口，等待客户端连接.........");

			future.channel().closeFuture().sync();
			future1.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// 优雅退出
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}
}
