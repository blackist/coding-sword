package netty.c5_communnication;

import java.util.concurrent.atomic.AtomicInteger;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * TODO Netty Server Socket Handler
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/7/4
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

	/**
	 * 因为多线程，所以使用原子操作类来进行计数
	 */
	private static AtomicInteger atomicInteger = new AtomicInteger();

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		Req req = (Req) msg;
		System.out.println(req.getMessage());
		Res res = new Res();
		res.setMessage("Hello, " + req.getMessage());
		ctx.writeAndFlush(res);
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
