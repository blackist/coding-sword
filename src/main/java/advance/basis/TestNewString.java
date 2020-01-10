package advance.basis;

/**
 * TODO New String
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/30
 */
public class TestNewString {

	public static void main(String[] args) {
		/**
		 * 执行过程和类的加载过程是有区别的。
		 * 在类加载的过程中，确实在运行时常量池中创建了一个 "abc" 对象，
		 * 而在代码执行过程中确实只创建了一个 String 对象。
		 */
		String a = new String("abc");
	}
}
