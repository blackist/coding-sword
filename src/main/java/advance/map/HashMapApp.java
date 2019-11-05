package advance.map;

/**
 * TODO HashMap源码
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/10
 */
public class HashMapApp {


	public static void main(String[] args) {
		IMap<String, String> IMap = new HashMapImpl<>();

		IMap.put("Black", "black");
		IMap.put("Foo", "foo");

		for (int i = 0; i < 100000; ++i) {
			IMap.put("Black" + i, "black" + i);
		}

		System.out.println(IMap.size());
		System.out.println(IMap.get("Foo"));
	}
}
