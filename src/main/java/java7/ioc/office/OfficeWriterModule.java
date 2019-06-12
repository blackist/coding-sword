package java7.ioc.office;

import com.google.inject.AbstractModule;

/**
 * TODO Office输出module
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/6/11
 */
public class OfficeWriterModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(OfficeWriter.class).toProvider(OfficeWriterProvider.class);
	}
}
