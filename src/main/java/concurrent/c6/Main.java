package concurrent.c6;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

import concurrent.c5.BLock;

/**
 * TODO 同步 AQS
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/7/11
 */
public class Main {

	private static int m = 0;
	private static Lock lock = new BLock();    // AQS
	private static CountDownLatch latch = new CountDownLatch(100);

	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[100];


		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(() -> {
				try {
					lock.lock();
					for (int j = 0; j < 1000; j++) m++;
				} finally {
					lock.unlock();
				}
				latch.countDown();
			});
		}

		for (Thread thread : threads) thread.start();

		latch.await();    // 等待线程顺序结束

		System.out.println(m);
	}
}
