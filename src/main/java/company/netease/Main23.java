package company.netease;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO 方块
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/27
 */
public class Main23 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line0 = br.readLine().trim();
		int T = Integer.parseInt(line0);


		for (int j = 0; j < T; ++j) {
			String[] line1 = br.readLine().trim().split(" ");
			int m = Integer.parseInt(line1[0]);
			int n = Integer.parseInt(line1[1]);
			char[][] arr = new char[m][n];
			for (int i = 0; i < m; i++) {
				char[] line2 = br.readLine().trim().toCharArray();
				for (int k = 0; k < n; k++) {
					arr[i][k] = line2[k];
				}
			}
			System.out.println(func(arr, m, n));
		}
	}

	private static int func(char[][] arr, int m , int n) {


		return 0;
	}

	private static int anchor(char[][] arr, int m, int n) {
		int[][] score = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int k = 0; k < n; k++) {
				// if (arr[i][])
			}
		}
		return 0;
	}
}
