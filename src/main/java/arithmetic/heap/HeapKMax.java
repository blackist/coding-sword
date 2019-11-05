package arithmetic.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * TODO 堆
 * <p>
 * 第 K 大的数
 * <p>
 * K 大小的小根堆，时间复杂度 N * logK
 * <p>
 * 堆每次插入删除的时间复杂度为 logK
 *
 * 使用优先级队列实现小根堆
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/23
 */
public class HeapKMax {

	public static void main(String[] args) {
		int K = 3;
		Queue<Integer> queue = new PriorityQueue<>();
		queue.add(Integer.MIN_VALUE);
		int[] arr = new int[]{1,10,2,9,3,8,4,7,5,6};
		for (int a : arr){
			if (queue.size() < K) {
				queue.add(a);
			} else if(a > queue.peek()) {
				queue.remove();
				queue.add(a);
			}
		}
		System.out.println(queue.peek());
	}
}
