package company.netease;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO ${TODO}
 *
 * @author LiangLiang.Dong<liangl.dong @ qq.com>
 * @since 2019/7/31 18:48.
 */
public class Cos2019_06Tower {

	public static void main(String[] args) throws IOException {
		my1();
	}

	public static void min() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line1 = br.readLine().trim().split(" ");
		int n = Integer.parseInt(line1[0]); // 塔的数量
		int k = Integer.parseInt(line1[1]); // 最多操作的次数
		String[] line2 = br.readLine().trim().split(" ");
		int[] a = new int[n]; // 记录塔的初始高度
		int sum = 0;
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(line2[i]);
			sum += a[i];
		}

		int max = 0; // a[]中最大元素的索引值
		int min = 0; // a[]中最小元素的索引值
		for (int i = 0; i < n; i++) {
			if (a[i] > a[max]) {
				max = i;
			}
			if (a[i] < a[min]) {
				min = i;
			}
		}

		boolean canBeStable = sum % n == 0; // 是否可达稳定
		StringBuilder sb = new StringBuilder(); // 存储输出结果
		System.out.println(getResult(a, 0, k, max, min, n, canBeStable, sb));
	}

	public static String getResult(int[] a, int m, int k, int max, int min,
								   int n, boolean canBeStable, StringBuilder sb) {
		if (a == null)
			return sb.toString();
		int maxValue = a[max];
		int minValue = a[min];
		int s = maxValue - minValue;
		if (m == k || (canBeStable && s == 0) || (!canBeStable && s == 1)) {
			// 移动次数用完 || 可达稳定且已达到稳定 || 不可达稳定但达到了最大稳定
			sb.insert(0, s + " " + m + "\n");
			return sb.toString();
		}
		sb.append(max + 1);
		sb.append(" ");
		sb.append(min + 1);
		sb.append("\n");
		a[max] -= 1;
		a[min] += 1;
		// 重新找到最大值和最小值对应的索引值
		for (int i = 0; i < n; i++) {
			if (a[i] > a[max]) {
				max = i;
			}
			if (a[i] < a[min]) {
				min = i;
			}
		}
		return getResult(a, m + 1, k, max, min, n, canBeStable, sb);
	}

	public static void my1() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line1 = br.readLine().trim().split(" ");
		int n = Integer.parseInt(line1[0]); // 塔的数量
		int k = Integer.parseInt(line1[1]); // 最多操作的次数
		String[] line2 = br.readLine().trim().split(" ");
		int sum = 0;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(line2[i]);
			sum += arr[i];
		}

		int min = 0;
		int max = 0;
		StringBuilder strB = new StringBuilder();
		int m = 0;
		for (int j = 0; j < k; ++j) {
			for (int i = 0; i < n; ++i) {
				if (arr[i] < arr[min]) min = i;
				if (arr[i] > arr[max]) max = i;
			}
			if (arr[max] - arr[min] > 0) {
				--arr[max];
				++arr[min];
				strB.append(max + 1).append(" ").append(min + 1).append("\n");
				++m;
			} else {
				break;
			}
		}
		max = min = 0;
		for (int i = 0; i < n; ++i) {
			if (arr[i] < arr[min]) min = i;
			if (arr[i] > arr[max]) max = i;
		}
		strB.insert(0, (arr[max] - arr[min]) + " " + m + "\n");

		System.out.println(strB.toString());
	}

	public static void my() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line1 = br.readLine().trim().split(" ");
		int n = Integer.parseInt(line1[0]); // 塔的数量
		int k = Integer.parseInt(line1[1]); // 最多操作的次数
		String[] line2 = br.readLine().trim().split(" ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(line2[i]);
		}

		int min = 0;
		int max = 0;
		StringBuilder strB = new StringBuilder();
		int m = 0;
		for (int j = 0; j < k; ++j) {
			for (int i = 0; i < n; ++i) {
				if (arr[i] < arr[min]) min = i;
				if (arr[i] > arr[max]) max = i;
			}
			if (arr[max] - arr[min] > 1) {
				--arr[max];
				++arr[min];
				strB.append(max + 1).append(" ").append(min + 1).append("\n");
				++m;
			} else {
				break;
			}
		}
		strB.insert(0, (arr[max] - arr[min]) + " " + m + "\n");

		System.out.println(strB.toString());
	}
}
