package company.meituan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO ABC
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/16
 */
public class Main1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line0 = br.readLine().trim();
		func(line0);
	}

	private static List<Integer> func(String S) {
		List<Integer> ans = new ArrayList<>();
		int[] map = new int[26];
		for (int i = 0; i < S.length(); i++) {
			map[S.charAt(i) - 'A'] = i;
		}
		int start = -1, end = 0;
		for (int i = 0; i < S.length(); i++) {
			end = Math.max(end, map[S.charAt(i) - 'A']);
			if (end == i) {
				// ans.add(end - start);
				System.out.print((end - start) + " ");
				start = end;
			}
		}
		return ans;
	}
}
