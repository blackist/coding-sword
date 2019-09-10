package company.ali;

import java.util.Scanner;

/**
 * TODO 兔子
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/8/30
 */
public class Main2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String line = scanner.nextLine();
		int n = Integer.parseInt(line);
		int[][] area = new int[n][n];

		for (int i = 0; i < n; i++) {
			line = scanner.nextLine();
			String[] split = line.split(",");
			if (split.length != n) {
				throw new IllegalArgumentException("错误输入");
			}
			int j = 0;
			for (String num : split) {
				area[i][j++] = Integer.parseInt(num);
			}
		}

		int minimumTimeCost = getMinimumTimeCost(n, area);
		System.out.println(minimumTimeCost);
	}

	/** 请完成下面这个函数，实现题目要求的功能 **/
	/**
	 * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
	 **/
	private static int getMinimumTimeCost(int n, int[][] area) {
		int row = n / 2;
		int min = Integer.MAX_VALUE;
		for (int k = 0; k < n; ++k) {
			int sum = 0;
			for (int j = k; j < n; j += 2) {
				for (int i = 0; i < row; ++i) {
					sum += area[2 * i + 1][j];
					min = Math.min(min, sum);
				}
			}

		}
		return min;
	}
}
