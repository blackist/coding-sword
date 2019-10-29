package advance.map;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * TODO
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/28
 */
public class TestSortedMap {

	public static void main(String[] args) {
		TreeMap<String, String> sortedMap = new TreeMap<>();
		sortedMap.put("a", "1");
		sortedMap.put("c", "3");
		sortedMap.put("e", "5");
		sortedMap.put("d", "4");
		sortedMap.put("b", "2");

		Iterator<String> iterator = sortedMap.keySet().iterator();
		Iterator<String> iterator2 = sortedMap.descendingKeySet().iterator();

		Comparator comparator = sortedMap.comparator();

		String fKey = sortedMap.firstKey();
		String lKey = sortedMap.lastKey();

		/**
		 * The SortedMap interface has a method named headMap() which
		 * returns a new Map which contains the first elements of the
		 * SortedMap according to the sort order used.
		 *
		 * The headMap() method takes a parameter that acts as
		 * a delimiter for what elements gets included in the returned head map.
		 *
		 * All elements with a key that is smaller than / earlier than the parameter
		 * passed to the headMap() method.
		 *
		 * Here is an example of obtaining a head map from a SortedMap via its headMap() method:
		 */
		SortedMap headMap = sortedMap.headMap("c");
		System.out.println(headMap);

		SortedMap tailMap = sortedMap.tailMap("c");
		System.out.println(tailMap);

		SortedMap subMap = sortedMap.subMap("b", "e");
		System.out.println(subMap);
	}
}
