package java7.ioc.office;

/**
 * TODO OfficeWriter父类
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/6/11
 */
public abstract class OfficeWriter {

	protected String path;

	protected String type;

	protected String content;

	protected int code;

	public abstract void write(String content);

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}
}
