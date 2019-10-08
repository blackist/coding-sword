package netty._aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;

/**
 * TODO 客户端 Handler
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/8
 */
public class ClientChannelHandler implements CompletionHandler<Integer, Attachment> {
	@Override
	public void completed(Integer result, Attachment att) {
		ByteBuffer buffer = att.getBuffer();
		if (att.isReadMode()) {
			System.out.println("Data Length from Server: " + result);
			// 读取来自服务端的数据
			buffer.flip();
			byte[] bytes = new byte[buffer.limit()];
			buffer.get(bytes);
			String msg = new String(bytes, Charset.forName("UTF-8"));
			System.out.println("Recieve Data from Server: " + msg);

			// 接下来，有以下两种选择:
			// 1. 向服务端发送新的数据
//            att.setReadMode(false);
//            buffer.clear();
//            String newMsg = "new message from client";
//            byte[] data = newMsg.getBytes(Charset.forName("UTF-8"));
//            buffer.put(data);
//            buffer.flip();
//            att.getConnection().write(buffer, att, this);
			// 2. 关闭连接
			try {
				att.getConnection().close();
			} catch (IOException e) {
			}
		} else {
			// 写操作完成后，会进到这里
			att.setReadMode(true);
			buffer.clear();
			att.getConnection().read(buffer, att, this);
		}
	}

	@Override
	public void failed(Throwable t, Attachment att) {
		System.out.println("Server No Response");
	}
}
