package concurrent.c6;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * TODO 同步器
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/7/11
 */
public class BLock implements Lock {

	private Sync sync = new Sync();

	private class Sync extends AbstractQueuedSynchronizer {

		@Override
		protected boolean tryAcquire(int arg) {
			assert arg == 1;
			if (compareAndSetState(0, 1)) {
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}

		@Override
		protected boolean tryRelease(int arg) {
			assert arg == 1;
			if (!isHeldExclusively()) throw new IllegalMonitorStateException("");
			setExclusiveOwnerThread(null);
			setState(0);
			return true;
		}

		@Override
		protected boolean isHeldExclusively() {
			return getExclusiveOwnerThread() == Thread.currentThread();
		}
	}

	@Override
	public void lock() {
		sync.acquire(1);
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {

	}

	@Override
	public boolean tryLock() {
		sync.acquire(1);
		return true;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return false;
	}

	@Override
	public void unlock() {
		sync.release(1);
	}

	@Override
	public Condition newCondition() {
		return null;
	}


}
