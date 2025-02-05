package AQS;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class SimpleLock extends AbstractQueuedSynchronizer {

    @Override
    protected boolean tryAcquire(int arg) {
        if (compareAndSetState(0, 1)) {
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    @Override
    protected boolean tryRelease(int arg) {
        if (getState() == 0) throw new IllegalMonitorStateException();
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }

    public void lock() {
        acquire(1);
    }

    public void unlock() {
        release(1);
    }

    public static void main(String[] args) {
        SimpleLock lock = new SimpleLock();
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread 1 acquired the lock");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("Thread 1 released the lock");
            }
        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread 2 acquired the lock");
            } finally {
                lock.unlock();
                System.out.println("Thread 2 released the lock");
            }
        }).start();
    }
}