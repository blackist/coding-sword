package java7.ioc.office;

import com.google.inject.Provider;

import java.util.Random;

/**
 * TODO OfficeWriterProvider
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/6/11
 */
public class OfficeWriterProvider implements Provider<OfficeWriter> {

	@Override
	public OfficeWriter get() {
		ExcelWriter writer = new ExcelWriter();
		writer.code = new Random().nextInt();
		writer.setType("Excel");
		writer.setPath("D:\\cache\\");
		return writer;
	}
}
