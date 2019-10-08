package netty._aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * TODO AsynchronousClient
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/8
 */
public class Client {

	public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
		AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
		Future<?> future = client.connect(new InetSocketAddress("127.0.0.1", Server.PORT));
		// blocking for connecting successfully.
		future.get();

		Attachment att = new Attachment();
		att.setConnection(client);
		att.setReadMode(false);
		att.setBuffer(ByteBuffer.allocate(2048));
		byte[] data = "I am blackist".getBytes();
		att.getBuffer().put(data).flip();

		client.write(att.getBuffer(), att, new ClientChannelHandler());

		TimeUnit.SECONDS.sleep(2000);
	}
}
