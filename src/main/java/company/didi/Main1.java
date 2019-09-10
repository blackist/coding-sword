package company.didi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO 算术转移
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/8/27
 */
public class Main1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		String[] line0 = br.readLine().trim().split(" ");
		int[] num = new int[n];
		int[] code = new int[n - 1];
		for (int i = 0; i < line0.length; ++i) {
			if (i % 2 == 0)
				num[i / 2] = Integer.parseInt(line0[i]);
			else
				code[i / 2] = code(line0[i]);
		}

		func(n, num, code);
	}

	private static int code(String code) {
		int _code = 0;
		switch (code) {
			case "+":
				_code = 0;
				break;
			case "-":
				_code = 1;
				break;
			case "*":
				_code = 2;
				break;
			case "/":
				_code = 3;
				break;
		}
		return _code;
	}

	private static String code_(int code) {
		String _code = null;
		switch (code) {
			case 0:
				_code = "+";
				break;
			case 1:
				_code = "-";
				break;
			case 2:
				_code = "*";
				break;
			case 3:
				_code = "/";
				break;
		}
		return _code;
	}

	private static void func(int N, int[] num, int[] code) {
		int pre = 0, next = 0, cur = 0;
		for (int i = 0; i < N - 1; ++i) {
			if (i == 0) {
				pre = 0;
			}
			if (i == N - 2) {
				next = 0;
			} else if (isAD(code[i + 1])) {
				next = 1;
			} else {
				next = 2;
			}
			if (isAD(code[i])) {
				cur = 1;
			} else {
				cur = 2;
			}

			if (cur == 2 || (pre != 2 && next != 2)) {
				if (num[i] > num[i + 1]) {
					int temp = num[i];
					num[i] = num[i + 1];
					num[i + 1] = temp;
				}
			}

			pre = cur;
		}
		System.out.print(num[0]);
		for (int i = 0; i < N - 1; ++i) {
			System.out.print(" " + code_(code[i]) + " " + num[i + 1]);
		}
	}

	private static boolean isAD(int a) {
		return a == 0 || a == 1;
	}
}
