package company.ali;

import java.util.Scanner;

/**
 * TODO
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/8/30
 */
public class Main3 {


/** 请完成下面这个函数，实现题目要求的功能 **/
	/**
	 * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
	 **/
	static String getIndexAndLongest(String users) {

		return null;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String res;

		String _users;
		try {
			_users = in.nextLine();
		} catch (Exception e) {
			_users = null;
		}

		res = getIndexAndLongest(_users);
		System.out.println(res);
	}
}
