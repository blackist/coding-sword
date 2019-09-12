package advance.map;

/**
 * TODO HashMap源码
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/10
 */
public class HashMapApp {


	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();

		map.put("Black", "black");
		map.put("Foo", "foo");

		for (int i = 0; i < 100000; ++i) {
			map.put("Black" + i, "black" + i);
		}

		System.out.println(map.size());
		System.out.println(map.get("Foo"));
	}
}
