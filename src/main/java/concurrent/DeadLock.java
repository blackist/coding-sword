package concurrent;

/**
 * TODO 思索
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/6/14
 */
public class DeadLock {

	/**
	 * 	死锁就是两个线程都被挂起，在等待区。程序终结
	 *
	 * 	线程1，实现的任务，先打开锁1，再打开锁2
	 * 	线程2，实现的任务，先打开锁2，再打开锁1
	 * 	线程1进入锁1，CPU切换线程2，线程2进入锁2；挂起等待。CPU切换线程1，挂起等待。
	 *
	 * 	线程1，实现的任务，先打开锁1，再打开锁2，打开锁2，再打开锁1，
	 * 	线程2，实现的任务，先打开锁1，再打开锁2，打开锁2，再打开锁1，
	 * 	线程1进入锁2，CPU切换线程2，线程2进入锁1；挂起等待。CPU切换线程1，挂起等待。
	 */
	public static void main(String[] args) {
		LockThread die1 = new LockThread(true);
		LockThread die2 = new LockThread(false);
		new Thread(die1, "Die1").start();
		new Thread(die2, "Die2").start();
		System.out.println("Thread Dead Test");
	}

	static class LockThread implements Runnable{

		private static Object obj1 = new Object();
		private static Object obj2 = new Object();
		private boolean flag;

		public LockThread(boolean flag){
			this.flag = flag;
		}

		@Override
		public void run(){
			System.out.println(Thread.currentThread().getName() + "运行");

			if(flag){
				synchronized(obj1){
					System.out.println(Thread.currentThread().getName() + "已经锁住obj1");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(obj2){
						// 执行不到这里
						System.out.println("1秒钟后，"+Thread.currentThread().getName()
								+ "锁住obj2");
					}
				}
			}else{
				synchronized(obj2){
					System.out.println(Thread.currentThread().getName() + "已经锁住obj2");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(obj1){
						// 执行不到这里
						System.out.println("1秒钟后，"+Thread.currentThread().getName()
								+ "锁住obj1");
					}
				}
			}
		}

	}
}



