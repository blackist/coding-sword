package java8.defaultmethod;

/**
 * TODO
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/6/12
 */
public interface FourWheeler {
	// default void go() {
	// 	System.out.println("I am FourWheeler");
	// }

	static void repair() {
		System.out.println("FourWheeler is being repaired");
	}
}