package interview.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * TODO 最大子序和
 * <p>
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/8/26
 */
public class SubarrayMax {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line0 = br.readLine().trim().split(" ");

		int[] arr = new int[line0.length];
		for (int i = 0; i < line0.length; i++) {
			arr[i] = Integer.parseInt(line0[i]);
		}

		System.out.println(func(arr));
	}

	private static int func(int[] arr) {
		int sum = 0, res = arr[0];
		int front = 0, rear = 0;
		for (int i = 0; i < arr.length; ++i) {
			// 正数增益
			// if (nums[i] > nums[i]) {
			if (sum > 0) {
				sum += arr[i];
				rear++;
			} else {
				sum = arr[i];
				front = rear = i;
			}
			res = Math.max(res, sum);
			System.out.println(front + " " + rear);
		}
		return res;
	}
}
