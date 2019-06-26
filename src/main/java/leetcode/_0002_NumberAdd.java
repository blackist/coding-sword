package leetcode;

/**
 * TODO 两数相加
 * <p>
 * Definition for singly-linked list.
 * * public class ListNode {
 * *     int val;
 * *     ListNode next;
 * *     ListNode(int x) { val = x; }
 * * }
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/6/26
 */
public class _0002_NumberAdd {

	public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
		int sum = 0;
		ListNode l = new ListNode(0);
		ListNode _l = l;
		while (l1 != null || l2 != null || sum != 0) {
			int _sum = 0;
			if (l1 != null) {
				_sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				_sum += l2.val;
				l2 = l2.next;
			}
			sum += _sum;
			_l.next = new ListNode(sum % 10);
			sum /= 10;
			_l = _l.next;
		}
		return l.next;
	}

	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode resultList = new ListNode(0);
		int cache = 0;

		ListNode l3 = resultList;
		while (l1 != null || l2 != null || cache > 0){
			int l1Val = l1 == null ? 0 : l1.val;
			int l2Val = l2 == null ? 0 : l2.val;
			int l3Val = l1Val + l2Val + cache;
			cache = 0;

			// 判断是否大于 9 大于9 进一位
			if (l3Val >  9){
				cache = 1;
				l3Val = l3Val - 10;
			}

			l3.next = new ListNode(l3Val);

			l3 = l3.next;
			l1 = l1 == null ? l1 : l1.next;
			l2 = l2 == null ? l2 : l2.next;
		}

		return resultList.next;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int sum = 0;
		int i = 0;
		ListNode l = new ListNode(0);
		ListNode _l = l;
		while (l1 != null || l2 != null) {
			int _sum = 0;
			if (l1 != null) {
				_sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				_sum += l2.val;
				l2 = l2.next;
			}
			sum += _sum * Math.pow(10, i);
			int val = (int) (sum / Math.pow(10, i)) % 10;
			_l.next = new ListNode(val);
			_l = _l.next;

			i++;
		}
		return l.next;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		_0002_NumberAdd add = new _0002_NumberAdd();
		ListNode l1 = new ListNode(2);
		ListNode l1_1 = new ListNode(4);
		ListNode l1_2 = new ListNode(3);
		l1.next = l1_1;
		l1_1.next = l1_2;
		ListNode l2 = new ListNode(5);
		ListNode l2_1 = new ListNode(6);
		ListNode l2_2 = new ListNode(4);
		l2.next = l2_1;
		l2_1.next = l2_2;
		long start = System.currentTimeMillis();
		add.addTwoNumbers2(l1, l2);
		System.out.println("Time: " + (System.currentTimeMillis() - start));

	}
}
