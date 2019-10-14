package company.ctrip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO 网格唯一路径
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/14
 */
public class Main3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line0 = br.readLine().trim().split(" ");
		int M = Integer.parseInt(line0[0]);
		int N = Integer.parseInt(line0[1]);

		int[][] arr = new int[M][N];
		for (int i = 0; i < M; i++) {
			String[] line1 = br.readLine().split(" ");
			for (int j = 0; j < N; ++j) {
				arr[i][j] = Integer.parseInt(line1[j]);
			}
		}
		System.out.println(uniquePathsWithObstacles(arr));
	}

	public static int uniquePathsWithObstacles(int[][] matrixGrid) {
		// 输入校验
		if (matrixGrid == null || matrixGrid.length < 1 || matrixGrid[0].length < 1
				|| matrixGrid[0][0] == 1
				|| matrixGrid[matrixGrid.length - 1][matrixGrid[0].length - 1] == 1) {
			return 0;
		}

		int rows = matrixGrid.length;
		int cols = matrixGrid[0].length;
		int[][] result = new int[rows][cols];

		// 第一个位置有多少种方法。无障碍就是1种，有障碍就是0种
		result[0][0] = matrixGrid[0][0] == 0 ?
				1 : 0;

		for (int i = 1; i < cols; i++) {
			result[0][i] = matrixGrid[0][i] == 0 ? result[0][i - 1] : 0;
		}

		for (int i = 1; i < rows; i++) {
			result[i][0] = matrixGrid[i][0] == 0 ? result[i - 1][0] : 0;
		}

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				result[i][j] = matrixGrid[i][j] == 0 ?
						result[i - 1][j] + result[i][j - 1] : 0;
			}
		}

		return result[rows - 1][cols - 1];
	}


	// 使用递归方法会超时
	public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
		// 输入校验
		if (obstacleGrid == null || obstacleGrid.length < 1 || obstacleGrid[0].length < 1
				|| obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
			return 0;
		}
		int[] result = {0};
		solve(obstacleGrid, 0, 0, result);
		return result[0];
	}

	public void solve(int[][] grid, int row, int col, int[] sum) {
		// 到达终点
		if (row == grid.length - 1 && col == grid[0].length - 1) {
			sum[0]++;
		}
		// 没有到终点，点在棋盘内。而且当前位置不是
		else if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 0) {
			// 往右走
			solve(grid, row, col + 1, sum);
			// 往下走
			solve(grid, row + 1, col, sum);
		}

	}
}
