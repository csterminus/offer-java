package juc;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author chengshi
 * @date 2024/6/13 16:08
 */
public class ThreadExcutorCounter {
    private static AtomicLong count = new AtomicLong(0);

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 6, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        for (int i = 0; i < 10; i++) {
            Thread a = new Thread(new TaskA());
            threadPoolExecutor.submit(a);
        }
        threadPoolExecutor.shutdown();
        try {
            threadPoolExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count.get());
    }

    static class TaskA implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                count.incrementAndGet();
            }
        }
    }
}
