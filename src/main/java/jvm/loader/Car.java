package jvm.loader;

/**
 * TODO org.blackist.jvm.loader.Car
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/7/6
 */
public class Car {

	public Car() {
		System.out.println("org.blackist.jvm.loader.Car loaded by:" + this.getClass().getClassLoader());
	}
}
