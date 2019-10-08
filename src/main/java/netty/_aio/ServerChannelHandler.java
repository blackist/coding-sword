package netty._aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;

/**
 * TODO 异步回调类
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/8
 */
public class ServerChannelHandler implements CompletionHandler<Integer, Attachment> {

	@Override
	public void completed(Integer result, Attachment attachment) {
		if (attachment.isReadMode()) {
			System.out.println("Data Length from Client: " + result);
			// Read Data
			ByteBuffer buffer = attachment.getBuffer();
			buffer.flip();
			byte[] bytes = new byte[buffer.limit()];
			buffer.get(bytes);
			String msg = new String(buffer.array()).trim();
			System.out.println("Recieve Data from Client: " + msg);

			// Response client
			buffer.clear();
			buffer.put("Data from Server".getBytes(Charset.forName("UTF-8")));
			attachment.setReadMode(false);
			buffer.flip();

			attachment.getConnection().write(buffer, attachment, this);
		} else {
			System.out.println("Data Length send Client: " + result);
			// 1.继续等待数据
			// attachment.setReadMode(true);
			// attachment.getBuffer().clear();
			// attachment.getConnection().read(attachment.getBuffer(), attachment, this);

			// 2. 断开本次链接
			try {
				attachment.getConnection().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void failed(Throwable exc, Attachment attachment) {
		System.out.println("Disconnected!");
	}
}
