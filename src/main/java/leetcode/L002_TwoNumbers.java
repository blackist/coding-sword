package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO 两数相加，逆序
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/6
 */
public class L002_TwoNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line0 = br.readLine().trim().split(",");
		ListNode l1 = new ListNode(0), rear1 = l1;
		for (String a : line0) {
			rear1.next = new ListNode(Integer.parseInt(a));
		}

		String[] line1 = br.readLine().trim().split(" ");
		ListNode l2 = new ListNode(0), rear2 = l2;
		for (String a : line1) {
			rear2.next = new ListNode(Integer.parseInt(a));
		}

		func(l1, l2);
	}

	private static void func(ListNode l1, ListNode l2) {
		ListNode res = new ListNode(0);
		while (l1.next != null && l2.next != null) {
			int diff = l1.next.val + l2.next.val;
		}
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}

