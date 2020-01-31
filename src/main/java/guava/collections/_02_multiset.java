package guava.collections;

import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;

import java.util.Set;

/**
 * TODO map
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2020/1/29
 */
public class _02_multiset {

	public static void main(String[] args) {

		Multiset<Integer> hset = HashMultiset.create();
		hset.add(5);
		hset.add(7);
		hset.add(7);
		System.out.println(hset);
		hset.setCount(5, 3);
		System.out.println(hset.count(7));
		Set<Multiset.Entry<Integer>> mentry = hset.entrySet();
		// entry include element and count
		System.out.println(mentry.iterator().next().getCount());
		// 所占空间随着不同元素的个数线性增加
		System.out.println(hset.elementSet());

		// Map
		Multiset<Integer> hashset = HashMultiset.create();
		Multiset<Integer> treeset = TreeMultiset.create();
		Multiset<Integer> linkedHashSet = LinkedHashMultiset.create();
		Multiset<Integer> concurrentHashSet = ConcurrentHashMultiset.create();
		Multiset<Integer> immutableSet = ImmutableMultiset.of(4, 5);

	}
}
