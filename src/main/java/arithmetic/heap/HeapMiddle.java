package arithmetic.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * TODO 两个数组 中位数
 * <p>
 * 两个堆，一个大根堆，一个小根堆，根据根的情况得到中位数
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/23
 */
public class HeapMiddle {

	Queue<Integer> bigHeap = new PriorityQueue<>(Comparator.reverseOrder());
	Queue<Integer> smallHeap = new PriorityQueue<>();

	public static void main(String[] args) {
		HeapMiddle middle = new HeapMiddle();
		int[] arr = new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6};
		for (int a : arr) {
			middle.addNum(a);
		}
		System.out.println(middle.getMiddle());
	}

	private void addNum(int num) {
		if (bigHeap.isEmpty()) {
			bigHeap.add(num);
			return;
		}
		if (bigHeap.size() == smallHeap.size()) {
			if (num < bigHeap.peek()) {
				bigHeap.add(num);
			} else {
				smallHeap.add(num);
			}
		} else if (bigHeap.size() > smallHeap.size()) {
			if (num < bigHeap.peek()) {
				smallHeap.add(bigHeap.poll());
				bigHeap.add(num);
			} else {
				smallHeap.add(num);
			}
		} else {
			if (num > smallHeap.peek()) {
				bigHeap.add(smallHeap.poll());
				smallHeap.add(num);
			} else {
				bigHeap.add(num);
			}
		}
	}

	private double getMiddle() {
		if (bigHeap.size() == smallHeap.size()) {
			return (bigHeap.element() + smallHeap.element()) / 2.0;
		} else if (bigHeap.size() > smallHeap.size()) {
			return bigHeap.element();
		} else {
			return smallHeap.element();
		}
	}
}
