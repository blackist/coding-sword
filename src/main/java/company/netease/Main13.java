package company.netease;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO 子序列
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/21
 */
public class Main13 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line0 = br.readLine().trim();
		int n = Integer.parseInt(line0);
		StringBuilder builder = new StringBuilder();
		while (n-- > 0) {
			String line1 = br.readLine().trim();
			int[] arr = new int[Integer.parseInt(line1)];
			String[] line2 = br.readLine().trim().split(" ");
			for (int j = 0; j < arr.length; ++j) {
				arr[j] = Integer.parseInt(line2[j]);
			}
			builder.append(func(arr)).append("\n");
		}
		System.out.println(builder.toString());
	}

	private static int func(int[] nums) {
		int seq = 0;
		int index = 0;
		long sum = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] >= sum) {
				sum += nums[i];
			} else {
				if (i - index > seq) {
					seq = i - index;
				}
				index = i;
			}
		}
		return seq;
	}
}
