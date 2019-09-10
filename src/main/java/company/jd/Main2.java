package company.jd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO 考场安排
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/8/24
 */
public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line0 = br.readLine().trim().split(" ");
		int n = Integer.parseInt(line0[0]);
		int m = Integer.parseInt(line0[1]);

		int[] p = new int[n * 2 + 1];

		int[][] r = new int[m][2];
		// 思路：r用来记录个人的关系数，关系数大于2的个人优先搬出教室
		for (int i = 0; i < m; i++) {
			String[] line1 = br.readLine().split(" ");
			r[i][0] = Integer.parseInt(line1[0]);
			r[i][1] = Integer.parseInt(line1[1]);

			p[r[i][0]]++;
			p[r[i][1]]++;
		}

		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 1;i<p.length;++i) {
			if (p[i] >= 2) {
				++count;
				sb.append(" ").append(i);
			}
		}
		System.out.println(count);
		System.out.println(sb.toString().trim());
	}
}
