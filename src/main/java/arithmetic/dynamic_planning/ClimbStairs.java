package arithmetic.dynamic_planning;

/**
 * TODO 爬楼梯
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/27
 */
public class ClimbStairs {

	public static void main(String[] args) {
		System.out.println(climb(3));
	}

	private static int climb(int n) {
		int[] arr = new int[n + 3];
		arr[1] = 1;
		arr[2] = 2;
		for (int i = 3; i <= n; ++i) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[n];
	}
}
