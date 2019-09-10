package company;

/**
 * TODO 寻找两个有序数组的中位数
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/6/29
 */
public class _0004_Mediam {

	/**
	 * 基于虚拟数组进行二分法"割"
	 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/4-xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-shu/
	 *
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;

		if (n > m) {
			return findMedianSortedArrays2(nums2, nums1);
		}

		int iLow = 0, iHigh = 2 * n, C1, C2, Lmax1 = 0, Lmax2 = 0, Rmin1 = 0, Rmin2 = 0;

		while (iLow <= iHigh) {
			C1 = (iLow + iHigh) / 2;
			C2 = m + n - C1;

			Lmax1 = (C1 == 0) ? Integer.MIN_VALUE : nums1[(C1 - 1) / 2];
			Rmin1 = (C1 == 2 * n) ? Integer.MAX_VALUE : nums1[C1 / 2];
			Lmax2 = (C2 == 0) ? Integer.MIN_VALUE : nums2[(C2 - 1) / 2];
			Rmin2 = (C2 == 2 * m) ? Integer.MAX_VALUE : nums2[C2 / 2];

			if (Lmax1 > Rmin2) {
				iHigh = C1 - 1;
			} else if (Lmax2 > Rmin1) {
				iLow = C1 + 1;
			} else {
				break;
			}
		}

		int Lmax = Math.max(Lmax1, Lmax2);
		int Rmin = Math.min(Rmin1, Rmin2);

		return (Lmax + Rmin) / 2.0;
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int aim_index = (nums1.length + nums2.length) / 2 + 1;
		int aim_odd;
		if ((nums1.length + nums2.length) % 2 == 1) {
			aim_odd = 1;
		} else {
			aim_odd = 0;
		}
		double aim = 0;
		int[] nums = new int[aim_index];
		int i = 0, j = 0, k = 0;
		while (i < nums1.length || j < nums2.length) {
			if (i < nums1.length && j < nums2.length) {
				if (nums1[i] > nums2[j]) {
					nums[k++] = nums2[j++];
				} else {
					nums[k++] = nums1[i++];
				}
			} else if (i < nums1.length) {
				nums[k++] = nums1[i++];
			} else {
				nums[k++] = nums2[j++];
			}
			if (aim_odd == 1) {
				if (k == aim_index) {
					aim = nums[k - 1];
					break;
				}
			} else {
				if (k == aim_index - 1) {
					aim += nums[aim_index - 2];
				} else if (k == aim_index) {
					aim += nums[aim_index - 1];
					aim /= 2;
					break;
				}
			}

		}
		return aim;
	}

	public static void main(String[] args) {
		_0004_Mediam mediam = new _0004_Mediam();

		// int[] nums1 = new int[]{2, 3, 5};
		// int[] nums1 = new int[]{10, 11, 12};
		int[] nums1 = new int[]{};
		int[] nums2 = new int[]{1, 4, 7, 9};

		double res = mediam.findMedianSortedArrays2(nums1, nums2);

		System.out.println("Mediam: " + res);
	}
}
