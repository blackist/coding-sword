package java7.concurrent.controlexecute;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * TODO 控制执行 任务建模
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/6/22
 */
public class TaskModel {

	private static ExecutorService service = Executors.newCachedThreadPool();

	public static void main(String[] args) {
		doFuture();
		doFutureTask();
	}

	private static void doFutureTask() {
		FutureTask<Long> futureTask1 = new FutureTask<>(new PrimeTask("futureTask1"));
		FutureTask<Long> futureTask2 = new FutureTask<>(new PrimeTask("futureTask2"));



		try {
			// FutureTask实现了Runnable接口 可由调度者调用
			// 1.作为Runnable有线程调用
			futureTask1.run();
			futureTask1.get();
			// 2.作为Callable被Executor调用
			service.submit(futureTask2);
			futureTask2.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}

	private static void doFuture() {
		Future<Long> fut = getNthPrime(1_000_000_000L);
		Long res = null;
		while (null == res) {
			System.out.println("waiting for Prime task");
			try {
				// get(timeout, unit) 会阻塞一会儿 没有结果的话继续执行
				res = fut.get(1, TimeUnit.SECONDS);
				System.out.println("get res: " + res);
			} catch (Exception e) {
			}
		}
		System.out.println("Prime Task ok");
	}

	private static Future<Long> getNthPrime(long param) {

		return service.submit(new PrimeTask("futureTask"));
	}

	private static class PrimeTask implements Callable<Long> {

		private String name;

		public PrimeTask(String name) {
			this.name = name;
		}

		@Override
		public Long call() throws Exception {
			System.out.println("Prime Task" + name + " running...");
			Thread.sleep(5000);
			long sum = 0L;
			for (int i = 0; i < 10000; i++) {
				sum += i;
			}
			return sum;
		}
	}
}
