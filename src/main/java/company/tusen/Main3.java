package company.tusen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * TODO 隔山打牛
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/29
 */
public class Main3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line0 = br.readLine().trim().split(" ");
		int n = Integer.parseInt(line0[0]);
		int m = Integer.parseInt(line0[1]);

		int[] arr = new int[m];
		for (int i = 0; i < m; i++) {
			String[] line1 = br.readLine().trim().split(" ");
			arr[i] = Integer.parseInt(line1[0]);
		}
	}

	private static int func(Map<Integer, Integer> pre, Map<Integer, Integer> next, int count) {

		Iterator<Integer> keys = next.keySet().iterator();
		while (keys.hasNext()) {
			int key = keys.next();
			if (next.containsKey(key + 1)) {
				if (next.get(key + 1) > 1) {
					next.put(key, next.get(key + 1) - 1);
				} else {
					next.remove(key + 1);
				}
			} else {

			}
			if (next.get(key) > 1) {
				next.put(key, next.get(key) - 1);
			} else {
				next.remove(key);
			}
			count++;
		}
		return count;
	}
}
