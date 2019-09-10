package company.netease;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO 链接：https://www.nowcoder.com/questionTerminal/12b1b8ef17e1441f86f322b250bff4c0
 * 来源：牛客网
 * <p>
 * 小易在学校中学习了关于字符串的理论, 于是他基于此完成了一个字典的项目。
 * <p>
 * 小易的这个字典很奇特, 字典内的每个单词都包含n个'a'和m个'z', 并且所有单词按照字典序排列。
 * <p>
 * 小易现在希望你能帮他找出第k个单词是什么。
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/8/2
 */
public class Cos2019_07Dict {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line0 = br.readLine().split(" ");
		int n = Integer.parseInt(line0[0]);
		int m = Integer.parseInt(line0[1]);
		int k = Integer.parseInt(line0[2]);

		index(n, m, k);
	}

	public static void index(int n, int m, int k) {

		StringBuilder sb = new StringBuilder();

		while (m > 0 && n > 0) {
			long count = 1;
			for (int i = 0; i < n - 1; ++i) {
				count *= n - 1 + m - i;
				count /= i + 1;
				if (k < count) {
					break;
				}
			}
			if (k <= count) {
				sb.append("a");
				--n;
			} else {
				sb.append("z");
				--m;
				k -= count;
			}
		}
		if (k != 1) {
			System.out.println(-1);
			return;
		}
		while(n-- > 0) sb.append("a");
		while(m-- > 0) sb.append("z");
		System.out.println(sb.toString());

	}
}
