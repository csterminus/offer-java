package juc;

//当使用synchronized (this)时，锁对象是当前实例对象本身。这意味着，同一时刻只有一个线程可以执行当前实例的该同步代码块。
public class SynchronizedThisExample {
    private int count = 0;

    public void increment() {
        synchronized (this) {
            count++;
        }
    }

    public int getCount() {
        synchronized (this) {
            return count;
        }
    }

    // ... 其他方法 ...
}
