package netty.c5_communnication;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

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

	private Timer timer = new Timer();

	private Client.ClientThread clientThread;

	/**
	 * 当客户端和服务端 TCP 链路建立成功之后，Netty 的 NIO 线程会调用 channelActive 方法
	 */
	@Override
	public void channelActive(final ChannelHandlerContext ctx) throws Exception {

		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				if (atomicInteger.get() >= 4) {
					atomicInteger.set(0);
					return;
				}
				Req req = new Req();
				req.setMessage("Clinet" + atomicInteger.incrementAndGet());
				ctx.writeAndFlush(req);
			}
		};
		// timer.schedule(timerTask, 0, 4000);
		Req req = new Req();
		req.setMessage("Clinet" + clientThread.getAtomicInteger().incrementAndGet());
		ctx.writeAndFlush(req);
	}

	/**
	 * 当服务端返回应答消息时，channelRead 方法被调用，从 Netty 的 ByteBuf 中读取并打印应答消息
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		try {
			Res res = (Res) msg;
			System.out.println(res.getMessage());
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

	public void setClientThread(Client.ClientThread clientThread) {
		this.clientThread = clientThread;
	}
}
