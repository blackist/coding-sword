package arithmetic;

import java.util.Scanner;

/**
 * TODO 递归二分存在性
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/18
 */
public class BinSearch1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] arr = str.split(" ");
		int[] b = new int[arr.length];
		for (int j = 0; j < b.length; j++) {
			b[j] = Integer.parseInt(arr[j]);
		}

		System.out.println(binary_searchs(b, 4, 0, b.length - 1));
	}

	//返回"-1"表示为找到
	//否则返回目标的下标（若有多个，只是其中一个）
	private static int binary_search(int[] arr, int target, int l, int r) {
		if (l > r) return -1;
		int mid = (l + r) >> 1;
		if (arr[mid] == target)
			return mid;
		else if (arr[mid] > target)
			return binary_search(arr, target, l, mid - 1);
		else
			return binary_search(arr, target, mid + 1, r);
	}

	private static int binary_searchs(int[] arr, int x, int l, int r) {
		int lt = l, rt = r;
		while (lt <= rt) {
			int mid = (lt + rt) >> 1;
			if (arr[mid] == x) return mid;
			else if (arr[mid] < x)
				lt = mid + 1;
			else
				rt = mid - 1;
		}
		return -1;
	}
}
