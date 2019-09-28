package arithmetic.dynamic_planning;

/**
 * TODO 找零钱
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/27
 */
public class CoinChange {

	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 5, 7, 10};
		int amout = 14;
		System.out.println(solution(nums, amout));
	}

	private static int solution(int[] nums, int amount) {
		int[] dp = new int[amount];
		for (int i = 0; i < nums.length; ++i) {
			dp[i] = -1;
		}
		dp[0] = 0;

		for (int i = 1; i <= amount; ++i) {
			for (int j = 0; j < nums.length; ++j) {
				// if ()
			}
		}

		return 0;
	}
}
