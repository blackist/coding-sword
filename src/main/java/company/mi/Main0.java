package company.mi;

import java.io.IOException;
import java.util.Arrays;

/**
 * TODO d
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/11
 */
public class Main0 {

	public static void main(String[] args) throws IOException {
		int[] _arr = new int[]{4, 2, 7, 6};
		System.out.println(solution(_arr));
	}

	private static int solution(int[] _arr) {
		int count = 0;
		// 对 arr 进行拷贝，不改变参数内容
		int[] arr = Arrays.copyOf(_arr, _arr.length);

		// 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
		for (int i = 1; i < arr.length; i++) {

			// 记录要插入的数据
			int tmp = arr[i];

			// 从已经排序的序列最右边的开始比较，找到比其小的数
			int j = i;
			while (j > 0 && tmp < arr[j - 1]) {
				arr[j] = arr[j - 1];
				j--;
			}

			// 存在比其小的数，插入
			if (j != i) {
				arr[j] = tmp;
				count++;
			}

		}
		System.out.println(Arrays.toString(arr));
		return count;
	}
}
