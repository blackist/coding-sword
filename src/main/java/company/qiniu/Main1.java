package company.qiniu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO 两数之和
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/17
 */
public class Main1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line0 = br.readLine().trim();
		int n = Integer.parseInt(line0);
		int[] arr = new int[n];
		String[] line1 = br.readLine().trim().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(line1[i]);
		}
		String line2 = br.readLine().trim();
		int target = Integer.parseInt(line2);
		func(arr, target);
	}

	private static void func(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (i != j && nums[i] + nums[j] == target) {
					System.out.println(i + " " + j);
					return;
				}
			}
		}
		System.out.println("-1 -1");
	}
}
