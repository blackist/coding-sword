package guava.collections;

import com.google.common.collect.BiMap;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.MutableClassToInstanceMap;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.RangeSet;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Table;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.TreeRangeSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * TODO Multimap
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2020/1/31
 */
public class _03_multimap {

	public static void main(String[] args) {
		// ListMlutimap
		ListMultimap<String, Integer> treeListMultimap =
				MultimapBuilder.treeKeys().arrayListValues().build();
		// SetMultimap
		SetMultimap<Integer, MyEnum> hashEnumMultimap =
				MultimapBuilder.hashKeys().enumSetValues(MyEnum.class).build();

		// Modification
		treeListMultimap.put("a", 1);
		treeListMultimap.put("a", 2);
		treeListMultimap.put("a", 3);
		treeListMultimap.put("b", 3);
		System.out.println(treeListMultimap);
		List<Integer> aList = treeListMultimap.get("a");
		System.out.println(aList);
		aList.clear();
		aList.add(8);
		System.out.println(treeListMultimap);
		List<Integer> cList = new ArrayList<>();
		cList.add(9);
		cList.add(10);
		treeListMultimap.putAll("c", cList);
		System.out.println(treeListMultimap);
		//returns the number of entries in the entire multimap,
		// not the number of distinct keys
		System.out.println(treeListMultimap.size());

		// Views
		Map<String, Collection<Integer>> listMap = treeListMultimap.asMap();
		Collection<Integer> cView = listMap.get("c");
		cView.remove(9);
		cView.add(11);
		cView.add(11);
		System.out.println(cView);
		Collection<Integer> bView = listMap.get("b");
		// return a non-null collection
		bView.remove(3);
		System.out.println(treeListMultimap.containsKey("b"));
		System.out.println(treeListMultimap.entries());
		System.out.println(treeListMultimap.keySet());
		System.out.println(treeListMultimap.keys());
		System.out.println(treeListMultimap.values());

		// BiMap
		BiMap<String, Integer> users = HashBiMap.create();
		users.put("auser", 1001);
		users.put("buser", 1002);
		System.out.println(users.inverse().get(1001));

		// Table
		Table<String, String, Integer> finance = HashBasedTable.create();
		finance.put("Jan", "in", 18);
		finance.put("Jan", "out", 8);
		finance.put("Feb", "in", 20);
		finance.put("Feb", "out", 6);
		System.out.println(finance);
		System.out.println(finance.row("Jan"));
		System.out.println(finance.column("in"));
		System.out.println(finance.rowMap().get("Jan"));
		System.out.println(finance.cellSet());

		// ClassToInstanceMap
		ClassToInstanceMap<Number> numberDefault = MutableClassToInstanceMap.create();
		numberDefault.put(Integer.class, 9);
		System.out.println(numberDefault);

		// RangeSet
		RangeSet<Integer> rangeSet = TreeRangeSet.create();
		rangeSet.add(Range.closed(1, 10));
		rangeSet.add(Range.closedOpen(11, 20));
		System.out.println(rangeSet);
		rangeSet.remove(Range.open(5,15));
		System.out.println(rangeSet);
		// view
		System.out.println(rangeSet.complement());

		// RangeMap
		RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
		rangeMap.put(Range.closed(1,10), "foo");
		rangeMap.put(Range.closed(3,6), "bar");
		System.out.println(rangeMap);
		rangeMap.remove(Range.closed(5,8));
		System.out.println(rangeMap);
	}


	enum MyEnum {

	}
}
