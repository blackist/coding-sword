package guava.basic;

import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * TODO 比较器, 排序
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2020/1/9
 */
public class _03_ordering {

	public static void main(String[] args) {
		String s1 = "1234";
		String s2 = "12345";
		StringOrdering byLengthOrdering = new StringOrdering();
		System.out.println(byLengthOrdering.compare(s1, s2));
		System.out.println(byLengthOrdering.reverse().compare(s1, s2));
	}

	private static class StringOrdering extends Ordering<String> {
		@Override
		public int compare(@Nullable String left, @Nullable String right) {
			return Ints.compare(left.length(), right.length());
		}
	}
}
