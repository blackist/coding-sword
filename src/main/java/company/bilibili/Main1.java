package company.bilibili;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO 字符串修改
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/10
 */
public class Main1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line0 = br.readLine().trim();
		String line1 = br.readLine().trim();

		System.out.println(func(line0.toCharArray(), line1.toCharArray()));
	}

	private static int func(char[] word1, char[] word2) {

		int m = word1.length + 1;
		int n = word2.length + 1;

		int[][] map = new int[m][n];
		for (int i = 0; i < n; ++i)
			map[0][i] = i;
		for (int i = 0; i < m; ++i)
			map[i][0] = i;
		for (int i = 1; i < m; ++i)
			for (int j = 1; j < n; ++j)
				map[i][j] = least(
						map[i - 1][j] + 1,
						map[i][j - 1] + 1,
						map[i - 1][j - 1] + (word1[i - 1] == word2[j - 1] ? 0 : 1));
		return map[m - 1][n - 1];
	}

	private static int least(int i1, int i2, int i3) {
		return Math.min(Math.min(i1, i2), Math.min(i2, i3));
	}
}
