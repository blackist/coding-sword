package netty._aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * TODO AIO Server
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/8
 */
public class Server {

	static final int PORT = 8080;

	public static void main(String[] args) throws IOException {
		// initiating and listening port
		AsynchronousServerSocketChannel server =
				AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(PORT));

		// using Attachment to transfer information
		Attachment att = new Attachment();
		att.setServer(server);

		server.accept(att, new CompletionHandler<AsynchronousSocketChannel, Attachment>() {
			@Override
			public void completed(AsynchronousSocketChannel conn, Attachment attachment) {

				try {
					SocketAddress clientAddr = conn.getRemoteAddress();
					System.out.println("New Connection: " + clientAddr);

					// 收到新的连接, server 重新调用 accept 方法等待新的连接进来;
					// 异步等待下一次连接, 然后去处理本次连接的任务
					attachment.getServer().accept(attachment, this);

					Attachment newAtt = new Attachment();
					newAtt.setServer(server);
					newAtt.setConnection(conn);
					newAtt.setReadMode(true);
					newAtt.setBuffer(ByteBuffer.allocate(2048));

					conn.read(newAtt.getBuffer(), newAtt, new ServerChannelHandler());
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			@Override
			public void failed(Throwable exc, Attachment attachment) {
				System.out.println("Accept Failed");
			}
		});

		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
