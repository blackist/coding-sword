package company.liulishuo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * TODO 礼物
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/11
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line0 = br.readLine().trim();
		int n = Integer.parseInt(line0);

		String[] line1 = br.readLine().trim().split(" ");
		int a = Integer.parseInt(line1[0]);
		int b = Integer.parseInt(line1[0]);

		int[] c = new int[n];
		int[] d = new int[n];
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			c[i] = Integer.parseInt(line[0]);
			d[i] = Integer.parseInt(line[1]);
		}

		func(n, a, b, c, d);
	}

	private static void func(int n, int a, int b, int[] c, int[] d) {

		/**
		 * 思路：计算a、b仓库给每个员工的邮费的差额，对差额排序，优先配送差额大的包裹
		 */
		int[] dec = new int[n];
		int[] pos = new int[n];

		for (int i = 0; i < n; ++i) {
			dec[i] = Math.abs(c[i] - d[i]);
			pos[i] = i;
		}

		// 对 arr 进行拷贝，不改变参数内容
		int[] arr = Arrays.copyOf(dec, dec.length);

		// 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
		for (int i = 1; i < arr.length; i++) {
			// 记录要插入的数据
			int tmp = arr[i];
			// 从已经排序的序列最右边的开始比较，找到比其小的数
			int j = i;
			while (j > 0 && tmp < arr[j - 1]) {
				arr[j] = arr[j - 1];
				pos[j] = pos[j - 1];
				j--;
			}

			// 存在比其小的数，插入
			if (j != i) {
				arr[j] = tmp;
				pos[j] = i;
			}

		}

		int i = n - 1;
		int count = 0;
		while (i >= 0) {
			if (b > 0 && c[pos[i]] > d[pos[i]]) {
				count += d[pos[i]];
				--b;
			} else if (a > 0) {
				count += c[pos[i]];
				--a;
			} else {
				count += d[pos[i]];
				--b;
			}
			--i;
		}

		System.out.println(count);
	}

}
