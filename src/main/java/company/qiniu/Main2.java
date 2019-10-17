package company.qiniu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * TODO 括号闭合
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/17
 */
public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line0 = br.readLine().trim();
		System.out.println(action(line0) ? 1 : 0);
	}

	static public boolean action(String s) {
		LinkedList<Character> queue = new LinkedList<Character>();
		char ch[] = s.toCharArray();
		for (int i = 0, length = ch.length; i < length; i++) {
			char a = ch[i];
			if (a == '{' || a == '(' || a == '[' || a == '<') {
				queue.push(a);// 压入栈
			} else {
				if (queue.size() == 0) {// 如果栈是空的
					return false;
				}
				char b = 0;
				switch (a) {
					case '}':
						b = '{';
						break;
					case ')':
						b = '(';
						break;
					case ']':
						b = '[';
						break;
					case '>':
						b = '<';
						break;
					default:
						return false;
				}
				Character top = queue.poll();// 弹出栈顶值
				if (top != b) {
					return false;
				}
			}
		}
		return queue.size() == 0;
	}
}
