package juc;

//当使用synchronized (Object o1)时，锁对象是一个特定的对象o1。
// 这意味着，同一时刻只有一个线程可以执行以o1为锁对象的同步代码块。
public class SynchronizedObjectExample {
    private int count = 0;
    private final Object lock = new Object();

    public void increment() {
        synchronized (lock) {
            count++;
        }
    }

    public int getCount() {
        synchronized (lock) {
            return count;
        }
    }
}
