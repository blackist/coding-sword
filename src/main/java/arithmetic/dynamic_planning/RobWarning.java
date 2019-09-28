package arithmetic.dynamic_planning;

/**
 * TODO 打家劫舍 不能抢相邻的两家
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/27
 */
public class RobWarning {

	public static void main(String[] args) {
		int[] arr = new int[]{5, 1, 6, 2, 1,7};
		System.out.println(solution(arr));
	}

	private static int solution(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}
		return dp[nums.length - 1];
	}
}
