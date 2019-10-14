package company.ctrip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * TODO 零食区域 喜好程度
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/14
 */
public class Main2 {

	static int BestMatch(int[] LimitArray, int[][] DegMatrix) {

		int dp[] = new int[DegMatrix.length + 1];
		dp[0] = 0;
		// M 个员工
		for (int j = 0; j < DegMatrix.length; j++) {
			int maxA = 0, maxE = 0;
			// N 个区域
			for (int i = 0; i < DegMatrix[0].length; i++) {
				if (LimitArray[i] == 0) {
					continue;
				}
				for (int k = 0; k < DegMatrix.length; k++)
					if (DegMatrix[k][0] != -1 && maxA < DegMatrix[k][i]) {
						maxA = i;
						maxE = k;
					}
			}
			LimitArray[maxA]--;
			dp[j + 1] += DegMatrix[maxE][maxA];
		}

		return dp[DegMatrix.length];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line0 = br.readLine().trim();
		String line1 = br.readLine().trim();
		int N = Integer.parseInt(line0);
		int M = Integer.parseInt(line1);

		int[] _LimitArray = new int[N];
		int[][] _DegMatrix = new int[M][N];
		for (int i = 0; i < N; i++) {
			String[] line2 = br.readLine().trim().split(" ");
			_LimitArray[i] = Integer.parseInt(line2[i]);
		}
		for (int i = 0; i < M; i++) {
			String[] line3 = br.readLine().trim().split(" ");
			for (int j = 0; j < N; j++) {
				_DegMatrix[i][j] = Integer.parseInt(line3[j]);
			}
		}
		System.out.println(BestMatch(_LimitArray, _DegMatrix));
	}

}
