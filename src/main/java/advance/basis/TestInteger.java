package advance.basis;

/**
 * TODO
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/30
 */
public class TestInteger {

	public static void main(String[] args) {
		Integer a = 100, b = 100, c = 666, d = 666;
		System.out.println(a == b);
		// -Djava.lang.Integer.IntegerCache.high=666 => true
		System.out.println(c == d);
	}
}
