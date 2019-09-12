package advance.map;

/**
 * TODO 自定义Map接口
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/12
 */
public interface Map<K, V> {

	V put(K k, V v);

	V get(K k);

	int size();

	interface Entry<K, V> {
		K getKey();

		V getValue();
	}
}
