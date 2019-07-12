package netty;

import java.util.concurrent.atomic.AtomicInteger;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * TODO Netty Server Socket Handler
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/7/4
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

	/**
	 * 因为多线程，所以使用原子操作类来进行计数
	 */
	private static AtomicInteger atomicInteger = new AtomicInteger();

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		/**
		 * 将 msg 转为 Netty 的 ByteBuf 对象，类似 JDK 中的 java.nio.ByteBuffer，不过 ButeBuf 功能更强，更灵活
		 */
		// ByteBuf buf = (ByteBuf) msg;
		/**
		 * readableBytes：获取缓冲区可读字节数,然后创建字节数组
		 * 从而避免了像 java.nio.ByteBuffer 时，只能盲目的创建特定大小的字节数组，比如 1024
		 **/
		// byte[] req = new byte[buf.readableBytes()];
		/**
		 * readBytes：将缓冲区字节数组复制到新建的 byte 数组中
		 * 然后将字节数组转为字符串
		 **/
		// buf.readBytes(req);
		// String body = new String(req, StandardCharsets.UTF_8);
		String body = (String) msg;
		System.out.println(Thread.currentThread().getName() + " " + atomicInteger.addAndGet(1) + " Rev: " + body);

		/**
		 * 回复消息
		 * copiedBuffer：创建一个新的缓冲区，内容为里面的参数
		 * 通过 ChannelHandlerContext 的 write 方法将消息异步发送给客户端
		 **/
		String res = "Server Receive Success: " + Thread.currentThread().getName() + System.getProperty("line.separator");
		ByteBuf resBuf = Unpooled.copiedBuffer(res.getBytes());
		// 每次写的时候，同时刷新，防止 TCP 粘包
		ctx.writeAndFlush(resBuf);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		/**
		 * flush：将消息发送队列中的消息写入到 SocketChannel 中发送给对方，为了频繁的唤醒 Selector 进行消息发送
		 * Netty 的 write 方法并不直接将消息写如 SocketChannel 中，调用 write 只是把待发送的消息放到发送缓存数组中，再通过调用 flush
		 * 方法，将发送缓冲区的消息全部写入到 SocketChannel 中
		 **/
		// ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
	}
}
