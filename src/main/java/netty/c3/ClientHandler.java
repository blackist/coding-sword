package netty.c3;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicInteger;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * TODO Netty Client Channel Handler
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/7/4
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

	/**
	 * 因为 Netty 采用线程池，所以这里使用原子操作类来进行计数
	 */
	private static AtomicInteger atomicInteger = new AtomicInteger();

	/**
	 * 当客户端和服务端 TCP 链路建立成功之后，Netty 的 NIO 线程会调用 channelActive 方法
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

		for (int i = 0; i < 5; i++) {
			Req req = new Req();
			req.setMessage("Clinet" + i);
			ctx.writeAndFlush(req);
		}
	}

	/**
	 * 当服务端返回应答消息时，channelRead 方法被调用，从 Netty 的 ByteBuf 中读取并打印应答消息
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		try {
			// ByteBuf buf = (ByteBuf) msg;
			// byte[] req = new byte[buf.readableBytes()];
			// buf.readBytes(req);
			// String body = new String(req, StandardCharsets.UTF_8);
			Res res = (Res) msg;
			System.out.println(res.getMessage());
			// ctx.close();
		} finally {
			ReferenceCountUtil.release(msg);
		}

	}

	/**
	 * 当发生异常时，打印异常 日志，释放客户端资源
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		/**释放资源*/
		ctx.close();
	}
}
