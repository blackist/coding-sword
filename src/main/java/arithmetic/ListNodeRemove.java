package arithmetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO 删除链表多个值
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/18
 */
public class ListNodeRemove {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] arr = str.split(" ");
		int[] b = new int[arr.length];
		for (int j = 0; j < b.length; j++) {
			b[j] = Integer.parseInt(arr[j]);
		}
		ListNode node = new ListNode(b);

		String str1 = sc.nextLine();
		String[] arr1 = str1.split(" ");
		List<Integer> list = new ArrayList<>();
		for (int j = 0; j < arr1.length; j++) {
			list.add(Integer.parseInt(arr1[j]));
		}

		ListNode n = removeElement(node, list);
		System.out.println(n == null ? "" : n.toString());
	}

	private static ListNode removeElement(ListNode head, List<Integer> list) {
		ListNode pre = head, cur = head;
		// 删除开始部分的节点
		while (cur != null && list.contains(cur.val)) {
			cur = cur.next;
			pre.next = null;
			pre = cur;
		}
		if (cur == null) {
			return cur;
		}
		cur = cur.next;
		// 删除中间部分的节点
		while (cur != null) {
			if (list.contains(cur.val)) {
				cur = cur.next;
				pre.next = pre.next.next;
			} else {
				pre = cur;
				cur = cur.next;
			}
		}

		return head;
	}
}

class ListNode {
	int val;
	ListNode next;

	public ListNode(int x) {
		val = x;
	}

	public ListNode(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("ARR CAN NOT BE EMPTY");
		}

		val = arr[0];
		//这个this是指实现这个内部类的对象
		ListNode cur = this;
		for (int i = 1; i < arr.length; i++) {
			cur.next = new ListNode(arr[i]);
			cur = cur.next;
		}
	}

	public String toString() {
		StringBuilder res = new StringBuilder();
		ListNode cur = this;
		while (cur != null) {
			res.append(cur.val + "->");
			cur = cur.next;
		}
		res.append("NULL");
		return res.toString();
	}


}