package java7.ioc.office;

import com.google.inject.Inject;

/**
 * TODO OfficeWriterService
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/6/11
 */
public class OfficeWriterService {

	private final OfficeWriter writer;

	@Inject
	public OfficeWriterService(OfficeWriter writer) {
		this.writer = writer;
	}

	public void writeData(String data) {
		writer.write(data);
	}
}
