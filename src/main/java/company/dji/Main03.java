package company.dji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO Game
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/8/6
 */
public class Main03 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String lines;
		while ((lines = br.readLine()) != null && !lines.isEmpty()) {
			String[] line = lines.trim().split(" ");
			int V = Integer.parseInt(line[0]);
			int N = Integer.parseInt(line[1]);
			int[] c = new int[N];
			String[] lineC = br.readLine().trim().split(" ");
			for (int i = 0; i < N; ++i) {
				c[i] = Integer.parseInt(lineC[i]);
			}
			int M = Integer.parseInt(br.readLine().trim());
			int[] pref = new int[M];
			for (int i = 0; i < M; ++i) {
				String[] prefs = br.readLine().trim().split(" ");
				pref[i] = Integer.parseInt(prefs[i]);
			}
			spend(V, N, c, M, pref);
		}
	}

	private static void spend(int V, int N, int[] c, int M, int[] pref) {
		/**
		 * 思路：
		 * 按照零食喜爱程度，拿总金额买入尽可能多的最爱零食，剩余的钱买其他零食，递归计算；减少一个最爱零食，继续递归。
		 */
	}
}
