package company.tiger;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * TODO arithmetic.Test
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/8
 */
public class Main1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();

		char[] s = line.toCharArray();

		Map<Integer, Integer> map = new HashMap<>();
		int l = 0, r;
		boolean nf = false;
		for (int i = 0; i < s.length; i++) {
			if (s[i] > '0' && s[i] < '9') {
				if (!nf) {
					l = i;
					nf = true;
				}
			} else {
				if (nf) {
					r = i;
					nf = false;
					int key = Integer.parseInt(line.substring(l, r));
					if (map.containsKey(key)) {
						map.put(key, map.get(key) + 1);
					} else {
						map.put(key, 1);
					}
				}
			}
		}
		int max = 0, key = 0;
		Set<Integer> it = map.keySet();
		for (int k : it) {
			if (max < map.get(k)) {
				max = map.get(k);
				key = k;
			}
		}
		System.out.println(key * max);
	}
}
