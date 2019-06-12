package java7.ioc.office;

import com.google.inject.Singleton;

/**
 * TODO ExcelWriter
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/6/11
 */
@Singleton
public class ExcelWriter extends OfficeWriter {

	@Override
	public void write(String content) {
		this.content = "Excel: " + content;
		System.out.println(this.content + " [by:" + this.code + "]");
	}
}
