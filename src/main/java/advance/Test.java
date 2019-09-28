package advance;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;

/**
 * TODO 测试
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/18
 */
public class Test {


	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>(1);
		map.put("a", "A");
		set(map);
		System.out.println(map);
	}

	public static void set(Map map) {
		map = null;
		Thread.State state;
		Class c;
		Object o;
	}
}
