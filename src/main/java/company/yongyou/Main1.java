package company.yongyou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO 指派
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/11
 */
public class Main1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line0 = br.readLine().trim();

		String _p = line0.substring(line0.indexOf("=") + 1, line0.indexOf(",")).trim();

		int n = Integer.parseInt(_p);

		String _v = line0.substring(line0.indexOf("[") + 1, line0.indexOf("]"));
		String[] vs = _v.split(",");
		int[] v = new int[vs.length];
		for (int i = 0; i < vs.length; i++) {
			v[i] = Integer.parseInt(vs[i]);
		}
	}

	private  void func(int P, int[] v) {

		Map<Integer, Integer> score = new HashMap<>();
		int power = P;
		for (int i = 0; i < v.length; ++i) {
			if (power >= v[i]) {
				if (score.containsKey(v[i])) {
					score.put(v[i], score.get(v[i]) + 1);
				} else {
					score.put(v[i], 1);
				}
			} else {
				Integer[] arr = (Integer[])score.keySet().toArray();
				Arrays.sort(arr);
				if (arr[0] > v[i]) {
					if (score.get(arr[0]) > 1) {
						score.put(arr[0], score.get(arr[0]) - 1);
					} else {
						score.remove(arr[0]);
						score.put(v[i], 1);
					}
				}
			}
		}


		System.out.println(score.size());
	}
}
