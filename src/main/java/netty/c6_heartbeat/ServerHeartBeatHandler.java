package netty.c6_heartbeat;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * TODO Netty Server Socket Handler
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/7/4
 */
public class ServerHeartBeatHandler extends ChannelInboundHandlerAdapter {

	private static HashMap<String, String> AUTH_IP_MAP = new HashMap<>();
	private static final String SUCCESS_KEY = "auth_success_key";

	static {
		AUTH_IP_MAP.put("192.168.11.115", "1234");
	}

	private boolean auth(ChannelHandlerContext ctx, Object msg) {
		String[] ret = ((String) msg).split(",");
		String auth = AUTH_IP_MAP.get(ret[0]);
		if (auth != null && auth.equals(ret[1])) {
			ctx.writeAndFlush(SUCCESS_KEY);
			return true;
		} else {
			ctx.writeAndFlush("auth failure!").addListener(ChannelFutureListener.CLOSE);
			return false;
		}
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		if (msg instanceof String) {
			auth(ctx, msg);
		} else if (msg instanceof ReqInfo){

		}
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
	}
}
