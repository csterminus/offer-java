package juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chengshi
 * @date 2024/6/5 17:36
 */
public class AtomicCounter {
    private AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        AtomicCounter counter = new AtomicCounter();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        try {
            t1.join();
            ;
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.getCount());
    }

    public void increment() {
        count.incrementAndGet();
    }

    private int getCount() {
        return count.get();
    }
}
