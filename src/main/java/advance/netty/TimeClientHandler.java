package advance.netty;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicInteger;

import advance.rmi.Client;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * TODO Netty Client Channel Handler
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/7/4
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

	/**
	 * 因为 Netty 采用线程池，所以这里使用原子操作类来进行计数
	 */
	private static AtomicInteger atomicInteger = new AtomicInteger();

	/**
	 * 当客户端和服务端 TCP 链路建立成功之后，Netty 的 NIO 线程会调用 channelActive 方法
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

		for (int i = 0; i < 10; i++) {
			String reqMsg = "我是客户端 " + i + ": " + Thread.currentThread().getName() + System.getProperty("line.separator");
			byte[] reqMsgByte = reqMsg.getBytes(StandardCharsets.UTF_8);
			ByteBuf reqByteBuf = Unpooled.buffer(reqMsgByte.length);
			/**
			 * writeBytes：将指定的源数组的数据传输到缓冲区
			 * 调用 ChannelHandlerContext 的 writeAndFlush 方法将消息发送给服务器
			 */
			reqByteBuf.writeBytes(reqMsgByte);
			ctx.writeAndFlush(reqByteBuf);
		}
	}

	/**
	 * 当服务端返回应答消息时，channelRead 方法被调用，从 Netty 的 ByteBuf 中读取并打印应答消息
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// ByteBuf buf = (ByteBuf) msg;
		// byte[] req = new byte[buf.readableBytes()];
		// buf.readBytes(req);
		// String body = new String(req, StandardCharsets.UTF_8);
		String body = (String) msg;
		System.out.println("Client " + (atomicInteger.addAndGet(1)) + "---" + Thread.currentThread().getName() + ", Server return Message：" + body);
		ctx.close();
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
