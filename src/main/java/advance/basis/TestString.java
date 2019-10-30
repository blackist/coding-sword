package advance.basis;

/**
 * TODO
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/29
 */
public class TestString {

	public static void main(String[] args) {
		String a = "abcd";
		String a1 = "abcd";
		String a2 = "ab";
		String a3 = "cd";
		String a4 = a2 + a3;
		String b = new String("abcd");
		System.out.println(a == a1);
		System.out.println(a == b);
		System.out.println(a == a4);

		// str6为变量，在运行期才会被解析
		String str6 = "b";
		String str7 = "a" + str6;
		String str67 = "ab";
		System.out.println("str7 = str67 : "+ (str7 == str67));

		// str8为常量变量，编译期会被优化
		final String str8 = "b";
		String str9 = "a" + str8;
		String str89 = "ab";
		System.out.println("str9 = str89 : "+ (str9 == str89));
	}
}
