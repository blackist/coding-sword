package company.meituan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO 评价排名
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/16
 */
public class Main2 {

	static final int MOD = 0xFFFE;
	static final Object LOCK = new Object();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line0 = br.readLine().trim();
		int n = Integer.parseInt(line0);

		func(n);
	}

	private static void func(int n) {
		ReviewEncourage encourage = new ReviewEncourage(n);
		PrizePool prizePool = new PrizePool();
		DeployA a = new DeployA(encourage, prizePool);
		DeployB b = new DeployB(encourage, prizePool);
		DeployC c = new DeployC(encourage, prizePool);
		a.start();
		b.start();
		c.start();
	}

	static class DeployA extends Thread {
		ReviewEncourage encourage;
		PrizePool prizePool;

		public DeployA(ReviewEncourage e, PrizePool p) {
			encourage = e;
			prizePool = p;
		}

		@Override
		public void run() {
			while (encourage.hasNext()) {
				synchronized (DeployA.class) {
					if (encourage.hasNext()&&encourage.user % 2 == 1) {
						encourage.user++;
						encourage.bonus(prizePool);
					}
				}
			}
		}
	}

	static class DeployB extends Thread {
		ReviewEncourage encourage;
		PrizePool prizePool;

		public DeployB(ReviewEncourage e, PrizePool p) {
			encourage = e;
			prizePool = p;
		}

		@Override
		public void run() {
			while (encourage.hasNext()) {
				synchronized (DeployA.class) {
					if (encourage.hasNext()&&encourage.user % 2 == 0 && (encourage.user >> 1) % 2 == 1) {
						encourage.user++;
						encourage.coupon(prizePool);
					}
				}
			}
		}
	}

	static class DeployC extends Thread {
		ReviewEncourage encourage;
		PrizePool prizePool;

		public DeployC(ReviewEncourage e, PrizePool p) {
			encourage = e;
			prizePool = p;
		}

		@Override
		public void run() {
			while (encourage.hasNext()) {
				synchronized (DeployA.class) {
					if (encourage.hasNext() && encourage.user % 2 == 0 && (encourage.user >> 1) % 2 == 0) {
						encourage.user++;
						encourage.contribution(prizePool);
					}
				}
			}
		}
	}

	static class ReviewEncourage {
		private volatile int user = 1;
		private int N;

		// 构造函数，n 为中奖用户数
		public ReviewEncourage(int n) {
			N = n;
		}

		public boolean hasNext() {
			return user <= N;
		}

		public void bonus(PrizePool prizePool) {
			prizePool.send("A");
		}  // 仅能打印 A，表示发放积分

		public void coupon(PrizePool prizePool) {
			prizePool.send("B");
		}  // 仅能打印 B，表示发放优惠券

		public void contribution(PrizePool prizePool) {
			prizePool.send("C");
		}  // 仅能打印 C，表示发放贡献值
	}

	/**
	 * PrizePool 类仅有一个 send 方法，实现如下
	 */
	public static class PrizePool {
		public void send(String input) {
			System.out.print(input);
		}
	}
}
