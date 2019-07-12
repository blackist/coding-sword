package netty.c3;

import java.io.Serializable;

/**
 * TODO 请求
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/7/12
 */
public class Req implements Serializable {

	private static final long serialVersionUID = 2311976361304924304L;
	private int id;
	private String name;
	private String message;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
