package company._58;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * TODO 饼干
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/12
 */
public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line0 = br.readLine().trim();
		int n = Integer.parseInt(line0);

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine().trim());
		}

		func(arr);
	}

	private static void func(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int count = 0;
		int last = 0;
		int descend = 0; // 1.上升  2。下降
		for (int i = 0; i < arr.length; ++i) {
			if (stack.isEmpty()) {
				stack.push(arr[i]);
			} else if (last < arr[i]) { // 上升
				if (descend == 2) {
					stack.push(arr[i]);
					int score = 0;
					while (!stack.isEmpty()) {
						stack.pop();
						++score;
						count += score;
					}
				} else {
					descend = 1;
					stack.push(arr[i]);
				}
			} else { // 下降
				if (descend == 1) {
					stack.push(arr[i]);
					int score = 0;
					while (!stack.isEmpty()) {
						stack.pop();
						++score;
						count += score;
					}
				} else {
					descend = 2;
					stack.push(arr[i]);
				}
			}
			last = arr[i];
			if (i == arr.length - 1) {
				int score = 0;
				while (!stack.isEmpty()) {
					stack.pop();
					++score;
					count += score;
				}
			}
		}
		System.out.println(count);
	}
}
