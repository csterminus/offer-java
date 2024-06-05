package juc;

/**
 * @author chengshi
 * @date 2024/6/5 17:42
 */

import java.util.concurrent.atomic.LongAdder;

public class LongAdderCounter {
    private LongAdder count = new LongAdder();

    public static void main(String[] args) {
        LongAdderCounter counter = new LongAdderCounter();
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
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());
    }

    public void increment() {
        count.increment();
    }

    public long getCount() {
        return count.sum();
    }
}

