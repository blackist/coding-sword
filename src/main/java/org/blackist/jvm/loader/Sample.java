package org.blackist.jvm.loader;

/**
 * TODO org.blackist.jvm.loader.Sample
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/7/6
 */
public class Sample {

	public Sample() {
		System.out.println("org.blackist.jvm.loader.Sample loaded by: " + this.getClass().getClassLoader());
		new Car();
	}
}
