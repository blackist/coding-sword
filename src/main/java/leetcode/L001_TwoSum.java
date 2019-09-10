package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO 两数之和
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/6
 */
public class L001_TwoSum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line0 = br.readLine().trim();
		int target = Integer.parseInt(line0);

		String[] line1 = br.readLine().split(",");
		int m = line1.length;
		int[] arr = new int[m];
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(line1[i]);
		}

		func(target, arr);
	}

	private static void func(int target, int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; ++i) {
			if (map.containsKey(nums[i])) {
				System.out.println(map.get(nums[i]) + ", " + i);
				break;
			}
			map.put(target - nums[i], i);
		}
	}
}
