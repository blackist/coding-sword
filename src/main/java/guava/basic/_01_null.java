package guava.basic;


import com.google.common.base.Optional;
import com.google.common.base.Strings;

/**
 * TODO _01_null
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2020/1/9
 */
public class _01_null {

	public static void main(String[] args) {
		Optional<Integer> possible = Optional.of(5);
		possible.isPresent();
		possible.get();
		possible.or(10);
		possible.orNull();
		possible.asSet();

		possible = Optional.absent();
		// 表示引用缺失
		possible = Optional.fromNullable(null);
		// 默认值
		Integer index = possible.or(10);

		String nullString = null;
		String emptyString = "";
		System.out.println(Strings.emptyToNull(emptyString));
		System.out.println(Strings.nullToEmpty(nullString));
		System.out.println(Strings.isNullOrEmpty(nullString));
	}
}
