package concurrent;

import com.sun.corba.se.impl.orbutil.concurrent.Mutex;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * TODO 自定义同步器
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/7/8
 */
public class CustomSyncronizer {

	ReentrantLock lock;
	CountDownLatch latch;
	Mutex mutex;
	AtomicInteger integer;
	AtomicReference<Integer> reference;
	AtomicStampedReference<Integer> stampedReference;
	ReentrantReadWriteLock reentrantReadWriteLock;
	Object object;
	ThreadLocal<Integer> threadLocal;


	public CustomSyncronizer() {
		try {
			this.getClass().getDeclaredField("va");
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}

	static class Sync extends AbstractQueuedSynchronizer {

	}
}
