package juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BatchTaskExecutor {

    public static void main(String[] args) {
        // 定义任务总数和每批任务数
        final int totalTasks = 100;
        final int batchSize = 10;

        // 创建一个固定大小的线程池
        ExecutorService executor = Executors.newFixedThreadPool(batchSize);

        // 任务定义
        Runnable task = new Runnable() {
            @Override
            public void run() {
                // 模拟任务执行
                System.out.println("Executing task by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(100); // 模拟任务执行时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // 循环执行任务
        for (int i = 0; i < totalTasks; i += batchSize) {
            // 创建一个CountDownLatch，每批次有batchSize个任务
            CountDownLatch latch = new CountDownLatch(batchSize);

            for (int j = 0; j < batchSize; j++) {
                executor.execute(() -> {
                    try {
                        task.run();
                    } finally {
                        // 任务执行完成后，计数减1
                        latch.countDown();
                    }
                });
            }

            try {
                // 等待这一批任务全部完成
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Batch " + (i / batchSize + 1) + " completed.");
        }

        // 关闭线程池
        executor.shutdown();
    }
}

