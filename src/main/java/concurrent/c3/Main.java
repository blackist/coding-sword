package concurrent.c3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO 同步 AQS
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/7/11
 */
public class Main {

	private static int m = 0;
	private static Lock lock = new ReentrantLock();	// AQS

	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[100];


		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(() -> {
				try {
					lock.lock();
					for (int j = 0; j < 100; j++) m++;
				} finally {
					lock.unlock();
				}
			});
		}

		for (Thread thread : threads) thread.start();

		for (Thread thread : threads) thread.join();	// 等待线程顺序结束

		System.out.println(m);
	}
}
