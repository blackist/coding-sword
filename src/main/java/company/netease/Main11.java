package company.netease;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO 求和
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/21
 */
public class Main11 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line0 = br.readLine().trim();
		int n = Integer.parseInt(line0);

		for (int i = 0; i < n; i++) {
			String line1 = br.readLine().trim();
			System.out.println(func(Integer.parseInt(line1)));
		}
	}

	private static StringBuilder builder = new StringBuilder();
	private static int func(int num) {
		if (builder.length()>0) {
			builder.delete(0, builder.length());
		}
		if (num <= 9) {
			return num;
		}
		int count = num / 9;
		int suf = num % 9;

		builder.append(suf == 0 ? "" : suf);
		for (; count > 0; --count) {
			builder.append(9);
		}

		return Integer.parseInt(builder.toString());
	}
}
