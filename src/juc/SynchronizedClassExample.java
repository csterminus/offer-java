package juc;

//以类的Class对象为锁，可以实现类的所有实例之间的同步。
// 这意味着，如果一个线程持有某个类的Class对象的锁，
// 那么其他线程将无法进入该类的任何以该Class对象为锁的同步代码块，
// 无论这些代码块位于哪个实例中。
public class SynchronizedClassExample {
    public void someMethod() {
        synchronized (SynchronizedClassExample.class) {
            // 同步代码块
        }
    }
}
