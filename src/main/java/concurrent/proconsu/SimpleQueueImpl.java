package concurrent.proconsu;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO 消息队列
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/21
 */
public class SimpleQueueImpl implements SimpleQueue {
	//定义泛型的集合
	final private LinkedList<Integer> list = new LinkedList<>();
	final private int MAX = 10; //最多10个元素

	//获取锁
	/**
	 * ReentrantLock
	 * 1.本身是显式锁
	 * 2.默认是非公平锁,要让其是公平锁,就是在构造的时候加入Boolean类型的True.
	 * 3.获取Condition的条件
	 */
	Lock lock = new ReentrantLock();   //这个锁一定是全局锁

	//获取Condition---线程之间的通信
	/**
	 * 这个与1.5之前是不一样的.
	 * 明确的知道启动的是那个线程,阻塞的是哪个线程
	 */
	//生产者----向其中增加数据
	private Condition producer = lock.newCondition();
	//消费者---从其中取数据(在这里比较队列的出现也是满足这个场景的)
	private Condition consumer = lock.newCondition();

	private AtomicInteger count = new AtomicInteger(0); //初始值为0

	/**
	 * 增加生产者数据
	 */
	public void push(int t) {
		try {
			lock.lock();
			while (list.size() == MAX) {
				producer.await();
			}
			list.add(t);
			count.getAndIncrement();
			//消费者进行消费,必须消费,要不然不起作用,也没有什么意义
			consumer.signal();
		} catch (Exception e) {
			e.getMessage();  //抛异常一定是抛出自定义的异常,而不应该直接把系统所带的异常抛出去.这样用户看不懂
			/**
			 * 所以对于异常而言:
			 * 1.满足了程序的容错性和可调节性
			 * 2.满足了用户的体验需求;
			 */
		} finally {
			lock.unlock();  //必须释放锁,synchrozized自动释放,lock必须成对
		}
	}

	/**
	 * 当然是与线程相关的
	 * <T> 这个必须是...,因为表明是泛型方法   T 返回的类型
	 */
	public int pop() {
		//通知生产者进行生产
		Integer t = null;
		lock.lock();//获取锁
		try {
			//集合是作为一个队列存在的,这个就是定义集合的目的,当让可以用对列代替
			while (list.size() == 0) {  //集合所能存的数据的大小,即容量的大小
				//停止消费
				consumer.await();
			}
			t = list.removeFirst();
			count.getAndDecrement();
			producer.signal();  //继续生产
		} catch (Exception e) {
			e.getMessage();
		} finally {
			lock.unlock();  //释放锁
		}
		return t;
	}

	public static void main(String[] args) {
		SimpleQueueImpl c = new SimpleQueueImpl();        //启动消费者线程
		new Thread(() -> {
			for (int j = 0; j < 5; j++) {
				int s = c.pop();
				System.out.println(s);
			}
		}, "Consumer").start();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//启动生产者线程
			new Thread(() -> {
				for (int j = 0; j < 25; j++) {
					c.push(j);
				}
			}, "Producer").start();
	}
}
