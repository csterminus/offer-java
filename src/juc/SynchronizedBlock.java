package juc;

// 修饰代码块
//synchronized 还可以修饰代码块，此时需要指定一个锁对象。
// 同一时刻只有一个线程可以持有该锁对象并进入该代码块。这种方式提供了更灵活的锁控制。
public class SynchronizedBlock {
    private final Object lock = new Object();
    private int count = 0;

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

    public static void main(String[] args) {
        SynchronizedBlock example = new SynchronizedBlock();

        // 创建多个线程来并发地修改计数器
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                example.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                example.increment();
            }
        });

        // 启动线程
        thread1.start();
        thread2.start();

        // 等待线程执行完毕
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 输出最终的计数器值
        System.out.println("Final count: " + example.getCount());
    }
}
