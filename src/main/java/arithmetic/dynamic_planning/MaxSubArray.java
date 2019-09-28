package arithmetic.dynamic_planning;

/**
 * TODO 最大子序列和
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/27
 */
public class MaxSubArray {

	public static void main(String[] args) {

		int[] arr = new int[]{-1, 0, -2, 3, 4, -5, 4};
		System.out.println(solution(arr));
	}

	private static int solution(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = dp[0];
		for (int i = 1; i < nums.length; ++i) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
			max = Math.max(dp[i], max);
		}
		return max;
	}
}
