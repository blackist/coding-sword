package company.bytedance;

import java.util.Random;

/**
 * TODO 随机7生成随机10
 * <p>
 * 1:	 100338
 * 2:	 99865
 * 3:	 99966
 * 4:	 100571
 * 5:	 99874
 * 6:	 99662
 * 7:	 100090
 * 8:	 100332
 * 9:	 99917
 * 10:	 99385
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/11
 */
public class Random7 {

	static Random random = new Random();

	private static int random7() {
		return random.nextInt(7) + 1;
	}

	private static int random10() {
		int res = 0;
		do {
			res = (random7() - 1) * 7 + random7();
		} while (res > 40);
		return res % 10 + 1;
	}

	public static void main(String[] args) {
		int[] a = new int[11];
		for (int i = 0; i < 1000000; i++) {
			a[random10()]++;
		}
		for (int i = 1; i < a.length; i++) {
			System.out.println(i + ":\t " + a[i]);
		}
	}
}
