package concurrent.c4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * TODO 自定义锁
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/7/11
 */
public class BLock implements Lock {

	private volatile int i = 0;

	@Override
	public void lock() {
		synchronized (this) {
			i = 1;
		}
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {

	}

	@Override
	public boolean tryLock() {
		return false;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return false;
	}

	@Override
	public void unlock() {
		synchronized (this) {
			i = 0;
		}
	}

	@Override
	public Condition newCondition() {
		return null;
	}
}
