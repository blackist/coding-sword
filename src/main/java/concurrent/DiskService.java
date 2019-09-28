package concurrent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * TODO
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/25
 */
public class DiskService implements Runnable {

	private CyclicBarrier c = new CyclicBarrier(4, this);
	private DiskMemory disk = new DiskMemory();
	private Executor exe = Executors.newFixedThreadPool(4);

	public void count() {
		for (int i = 0; i < 4; ++i) {
			exe.execute(() -> {
				disk.setSize(new DiskMemory().getSize());
				System.out.println(Thread.currentThread().getName());
				try {
					c.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
	}

	@Override
	public void run() {
		System.out.println(disk.getTotalSize());
	}

	public static void main(String[] args) {
		new DiskService().count();
	}

	private class DiskMemory {
		int size = 0;

		int getSize() {
			return 3;
		}

		void setSize(int s) {
			size += s;
		}

		int getTotalSize() {
			return size;
		}
	}
}
