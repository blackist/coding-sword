package netty._aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;

/**
 * TODO Completion Attachment
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/8
 */
public class Attachment {

	private AsynchronousServerSocketChannel server;
	private AsynchronousSocketChannel connection;
	private boolean readMode;
	private ByteBuffer buffer;

	public AsynchronousServerSocketChannel getServer() {
		return server;
	}

	public void setServer(AsynchronousServerSocketChannel server) {
		this.server = server;
	}

	public AsynchronousSocketChannel getConnection() {
		return connection;
	}

	public void setConnection(AsynchronousSocketChannel connection) {
		this.connection = connection;
	}

	public boolean isReadMode() {
		return readMode;
	}

	public void setReadMode(boolean readMode) {
		this.readMode = readMode;
	}

	public ByteBuffer getBuffer() {
		return buffer;
	}

	public void setBuffer(ByteBuffer buffer) {
		this.buffer = buffer;
	}
}
