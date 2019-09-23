package company.youzan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO 搜索
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/17
 */
public class Main1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		while (scanner.hasNext()) {
			list.add(scanner.nextInt());
		}
		System.out.println(lack(list));
	}

	private static Integer lack(List<Integer> source) {
		int n = source.size();

		int sum1 = n * (n + 1) / 2;
		int sum2 = 0;
		for (int x : source) {
			sum2 += x;
		}

		return sum1 - sum2;
	}
}
