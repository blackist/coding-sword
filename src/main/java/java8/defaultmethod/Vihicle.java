package java8.defaultmethod;

/**
 * TODO Vihicle
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/6/12
 */
public interface Vihicle {
	default void go() {
		System.out.println("I am Vihicle");
	}
}
