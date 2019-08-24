package leetcode.trend;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TODO Game
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/8/6
 */
public class Main02 {

	private static String add(String num1, String num2) {
		//Please write your code here
		int[] a = new int[num1.length()];
		int[] b = new int[num2.length()];
		// 1 转化为整数数组
		int api = 0;
		int la = num1.length();
		if (num1.indexOf('.') > 0) {
			for (int i = 0; i < la; ++i) {
				if (num1.charAt(i) == '.') {
					api = i;
					a[i] = -1;
					continue;
				}
				a[i] = Integer.parseInt(num1.charAt(i) + "");
			}
		} else {
			for (int i = 0; i < la; ++i) {
				a[i] = Integer.parseInt(num1.charAt(i) + "");
			}
		}
		System.out.println(Arrays.toString(a));
		int lb = num2.length();
		int bpi = 0;
		if (num2.indexOf('.') > 0) {
			for (int i = 0; i < lb; ++i) {
				if (num2.charAt(i) == '.') {
					b[i] = -1;
					bpi = i;
					continue;
				}
				b[i] = Integer.parseInt(num2.charAt(i) + "");
			}
		} else {
			for (int i = 0; i < lb; ++i) {
				b[i] = Integer.parseInt(num2.charAt(i) + "");
			}
		}
		System.out.println(Arrays.toString(b));

		// 2 检索小数点位置
		// api bpi
		// 3 小数点前后的值分别相加
		StringBuilder res = new StringBuilder();
		// 3.1 小数部分
		boolean sec = false;
		if (la - api > lb - bpi) {
			for (int k = la - 1; k >= (api + lb - bpi); --k) {
				res.insert(0, a[k]);
			}
			int j = lb - 1;
			for (int k = api + lb - bpi; k > api; --k, --j) {
				int s = a[k] + b[j];
				s += sec ? 1 : 0;
				sec = false;
				res.insert(0, s % 10);
				if (s > 9) sec = true;
			}
		} else {
			for (int k = lb - 1; k >= (bpi + la - api); --k) {
				res.insert(0, b[k]);
			}
			int j = la - 1;
			for (int k = bpi + la - api; k > bpi; --k, --j) {
				int s = b[k] + a[j];
				s += sec ? 1 : 0;
				sec = false;
				res.insert(0, s % 10);
				if (s > 9) sec = true;
			}
		}
		// 有小数运算则加 '.'
		if (res.length() != 0) {
			res.insert(0, '.');
		}
		// 3.2 整数部分
		boolean dec = sec;
		if (api >= bpi) {
			int l = api - 1;
			for (int j = bpi - 1; j >= 0; --j, --l) {
				int s = a[l] + b[j];
				s += dec ? 1 : 0;
				dec = false;
				res.insert(0, s % 10);
				if (s > 9) dec = true;
			}
			for (int i = l; i >= 0; ++i) {
				int s = a[i];
				if (dec) {
					s += 1;
					dec = false;
				}
				res.insert(0, s % 10);
				if (s > 9) dec = true;
			}
		} else {
			int l = bpi - 1;
			for (int j = api - 1; j >= 0; --j, --l) {
				int s = b[l] + a[j];
				s += dec ? 1 : 0;
				dec = false;
				res.insert(0, s % 10);
				if (s > 9) dec = true;
			}
			for (int i = l; i >= 0; ++i) {
				int s = b[i];
				if (dec) {
					s += 1;
					dec = false;
				}
				res.insert(0, s % 10);
				if (s > 9) dec = true;
			}
		}
		if (dec) {
			res.insert(0, 1);
		}

		return res.toString();
	}

	// please don't modify any code below.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String num1 = sc.nextLine();
		String num2 = sc.nextLine();

		String sum = add(num1, num2);
		System.out.println(sum);
	}

}
