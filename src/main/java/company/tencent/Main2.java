package company.tencent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO 中位数
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/17
 */
public class Main2 {

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] line0 = br.readLine().trim().replace("[", "").replace("]","").split(",");
	    int[] n = new int[line0.length];
		for (int i = 0; i < line0.length; i++) {
			n[i] = Integer.parseInt(line0[i].trim());
		}

		String[] line1 = br.readLine().trim().replace("[", "").replace("]","").split(",");
		int[] m = new int[line1.length];
		for (int i = 0; i < line1.length; i++) {
			m[i] = Integer.parseInt(line1[i].trim());
		}
		System.out.println(findMedianSortedArrays(n, m));
	}


	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] nums;
		int m = nums1.length;
		int n = nums2.length;
		nums = new int[m + n];
		if (m == 0) {
			if (n % 2 == 0) {
				return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
			} else {

				return nums2[n / 2];
			}
		}
		if (n == 0) {
			if (m % 2 == 0) {
				return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
			} else {
				return nums1[m / 2];
			}
		}

		int count = 0;
		int i = 0, j = 0;
		while (count != (m + n)) {
			if (i == m) {
				while (j != n) {
					nums[count++] = nums2[j++];
				}
				break;
			}
			if (j == n) {
				while (i != m) {
					nums[count++] = nums1[i++];
				}
				break;
			}

			if (nums1[i] < nums2[j]) {
				nums[count++] = nums1[i++];
			} else {
				nums[count++] = nums2[j++];
			}
		}

		if (count % 2 == 0) {
			return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
		} else {
			return nums[count / 2];
		}
	}
}
