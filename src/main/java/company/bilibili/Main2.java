package company.bilibili;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO 2
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/10
 */
public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line0 = br.readLine().trim();
		int n = Integer.parseInt(line0);
		func(n);
	}

	private static void func(int N) {
		int count = 1, n = 2 * N;
		for (int i = 2; i <= Math.sqrt(n); ++i) {
			if (n % i == 0) {
				int _end = (n / i + i - 1) / 2;
				int _sta = _end - n / i + 1;
				if ((_sta + _end) * (_end - _sta + 1) == n)
					count++;
			}
		}
		System.out.println(count);
	}
}
