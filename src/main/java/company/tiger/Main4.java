package company.tiger;

import java.util.Scanner;

/**
 * TODO 连续数字
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/10
 */
public class Main4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		int min = 101, max = 1, count = 0;
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
			if (a[i] < min) {
				if (a[i] != 0)
					min = a[i];
				else
					count++;
			} else if (a[i] > max) {
				max = a[i];
			}
		}
	}

	private static void solution() {

	}
}
