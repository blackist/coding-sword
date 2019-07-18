package netty.c3;

import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;

import io.netty.handler.codec.marshalling.DefaultMarshallerProvider;
import io.netty.handler.codec.marshalling.DefaultUnmarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallingDecoder;
import io.netty.handler.codec.marshalling.MarshallingEncoder;
import io.netty.handler.codec.marshalling.UnmarshallerProvider;

/**
 * TODO Marshalling序列化类
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/7/12
 */
public class MarshallingCodeFactory {

	public static MarshallingEncoder getEncoder() {
		//这里表示的是支持java serial对象的序列化。所以我们传输的对象要实现Serializable接口
		MarshallerFactory factory = Marshalling.getProvidedMarshallerFactory("serial");
		MarshallingConfiguration configuration = new MarshallingConfiguration();
		configuration.setVersion(5);
		MarshallerProvider provider = new DefaultMarshallerProvider(factory, configuration);
		MarshallingEncoder encoder = new MarshallingEncoder(provider);
		return encoder;
	}

	public static MarshallingDecoder getDecoder() {
		MarshallerFactory factory = Marshalling.getProvidedMarshallerFactory("serial");
		MarshallingConfiguration configuration = new MarshallingConfiguration();
		configuration.setVersion(5);
		UnmarshallerProvider provider = new DefaultUnmarshallerProvider(factory, configuration);
		MarshallingDecoder decoder = new MarshallingDecoder(provider);
		return decoder;
	}
}
