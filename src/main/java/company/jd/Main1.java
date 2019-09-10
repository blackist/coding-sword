package company.jd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO 排队
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/8/24
 */
public class Main1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line0 = br.readLine().trim();
		int N = Integer.parseInt(line0);
		int[] h = new int[N];
		String[] line1 = br.readLine().split(" ");
		for (int i = 0; i < line1.length; i++) {
			h[i] = Integer.parseInt(line1[i]);
		}

		System.out.println(group(h, 0, 0));
	}

	private static int group(int[] h, int remain, int groups) {
		// 1.找到数组中的最小值h[min]，将数组一分为二
		// 2.左边数组hl从h[0]到h[min]，右边数组hr从h[min+1]到h[N-1]
		// 3.找到hl中的最大值hl[max]，检索hr中小于hl[max]的值hr[less]
		// 4.若存在hr[less]，则将hr[0]到hr[less]归并至hl,hl成为一个独立的组别;若不存在，则hl成为一个独立的组别。
		// 5.递归地对hr进行分组，直到hr为空
		if (h.length - remain < 2)
			return groups;
		else if (h.length - remain == 2)
			return ++groups;

		int minIndex = remain;
		for (int i = minIndex; i < h.length;++i) {
			if (h[i] < h[minIndex]) {
				minIndex = i;
			}
		}

		int hlMaxIndex = remain;
		for (int i = remain; i < minIndex; ++i) {
			if (h[i] > h[hlMaxIndex]) {
				hlMaxIndex = i;
			}
		}
		int hrLessIndex = minIndex;
		for (int i = remain + minIndex + 1; i < h.length; ++i) {
			if (h[i] < h[hlMaxIndex]) {
				hrLessIndex = i;
			}
		}

		return group(h, hrLessIndex+1, ++groups);
	}
}
