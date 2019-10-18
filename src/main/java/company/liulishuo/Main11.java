package company.liulishuo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * TODO 火车进站
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/18
 */
public class Main11 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line0 = br.readLine().trim().split(" ");
		int s[] = new int[line0.length + 1];
		for (int i = 1; i < s.length; i++) {
			s[i] = Integer.parseInt(line0[i-1]);
		}

		String[] line1 = br.readLine().trim().split(" ");
		int t[] = new int[line1.length + 1];
		for (int i = 1; i < t.length; i++) {
			t[i] = Integer.parseInt(line1[i-1]);
		}

		int n = s.length;
		Arrays.sort(s);
		Arrays.sort(t);
		int ans = 0;
		for (int i = 1, j = 1; i < n; ) {
			if (s[i] <= t[j]) {
				if (ans < i - j) ans = i - j;
				i++;
			} else j++;
		}
		System.out.println(ans + 1);
	}
}
