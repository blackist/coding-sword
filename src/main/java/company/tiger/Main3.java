package company.tiger;

/**
 * TODO 多米诺骨牌
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/8
 */
public class Main3 {

	public static void main(String[] args) {
		System.out.println(integerBreak(5));
		String a = "";
	}

	public static int integerBreak(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
			}
		}

		return dp[n];
	}
}
