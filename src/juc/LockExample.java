package juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    private final Lock lock = new ReentrantLock();

    public void doWork() {
        lock.lock();
        try {
            // 临界区代码
            System.out.println("Thread is working");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockExample example = new LockExample();

        Thread thread1 = new Thread(example::doWork);
        Thread thread2 = new Thread(example::doWork);

        thread1.start();
        thread2.start();
    }
}
