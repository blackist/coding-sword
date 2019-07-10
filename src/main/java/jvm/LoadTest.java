package jvm;

/**
 * TODO 类加载过程
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/7/10
 */
class Singleton {
	private static Singleton singleton = new Singleton();
	public static int counter1;
	public static int counter2 = 0;

	private Singleton() {
		counter1 = 2;
		counter2 = 2;
	}
	public static Singleton getInstance() {
		return singleton;
	}
}
public class LoadTest {

	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		System.out.println("counter1 = " + singleton.counter1);
		System.out.println("counter1 = " + singleton.counter2);
	}
}
