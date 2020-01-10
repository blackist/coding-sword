package guava.basic;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

import org.jetbrains.annotations.NotNull;

/**
 * TODO Objects 常用方法
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2020/1/10
 */
public class _04_common_methods {

	public static void main(String[] args) {
		Objects.equal(null, null);
		PageContent content = new PageContent();
		System.out.println(content.toString());
	}

	private static class PageContent implements Comparable<PageContent> {
		int index;
		String content;

		@Override
		public int hashCode() {
			return java.util.Objects.hash(index, content);
		}

		@Override
		public String toString() {
			return MoreObjects.toStringHelper(this)
					.add("hot", 100)
					.toString();
		}

		@Override
		public int compareTo(@NotNull PageContent o) {
			return ComparisonChain.start()
					.compare(index, o.index)
					.compare(content, o.content)
					.compare(content, o.content, Ordering.natural().nullsFirst())
					.result();
		}
	}
}
