package company.youzan;

import java.util.Scanner;

/**
 * TODO 得的
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/17
 */
public class Main2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		System.out.println(getResultString(str));
	}

	private static String getResultString(String s) {
		if (s == null || s.length() == 0)
			return "";

		int[] range = new int[2];
		char[] str = s.toCharArray();
		for (int i = 0; i < s.length(); ++i) {
			i = longest(str, i, range);
		}

		return s.substring(range[0], range[1] + 1);
	}

	private static int longest(char[] str, int low, int[] range) {
		int high = low;
		while (high < str.length - 1 && str[high + 1] == str[low]) {
			high++;
		}
		int ans = high;
		while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
			low--;
			high++;
		}
		if (high - low > range[1] - range[0]) {
			range[0] = low;
			range[1] = high;
		}
		return ans;
	}
}
