package jvm;

/**
 * TODO 常量池
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/7/10
 */
public class StaticPool {


	private static final String O = "abcd";
	private static final String A = "ab";
	private static final String B = "cd";
	private static final String C = A + B;

	public static void main(String[] args) {
		String run = "RUN";
		String running = run.intern();

		System.out.println(C == O);
		String x = "abcd".intern();
		System.out.println(x == O);
	}
}
