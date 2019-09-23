package company.netease;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO 逆序
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/21
 */
public class Main14 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line0 = br.readLine().trim();
		int n = Integer.parseInt(line0);

		int[] arr = new int[n];
		String[] line1 = br.readLine().trim().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(line1[i]);
		}
		System.out.println(func(arr));
	}

	private static int func(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length - 1; ++i) {
			for (int j = i + 1; j < arr.length; ++j) {
				if (arr[i] > arr[j]) {
					sum += j - i;
				}
			}
		}
		return sum;
	}
}
