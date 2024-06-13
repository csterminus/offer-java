package juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) {
        // Initialize CountDownLatch with 3, because we have 3 tasks to wait for
        CountDownLatch latch = new CountDownLatch(3);

        // Create and start three threads
        new Thread(new Task(latch), "Thread-1").start();
        new Thread(new Task(latch), "Thread-2").start();
        new Thread(new Task(latch), "Thread-3").start();

        try {
            // Main thread will wait until latch count reaches zero
            System.out.println("Main thread waiting for tasks to complete.");
            latch.await();
            System.out.println("All tasks have completed. Main thread proceeding.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    static class Task implements Runnable {
        private CountDownLatch latch;

        public Task(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                // Simulate some work with sleep
                System.out.println(Thread.currentThread().getName() + " is performing a task.");
                Thread.sleep((long) (Math.random() * 1000));
                System.out.println(Thread.currentThread().getName() + " has completed the task.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Decrement the count of the latch
                latch.countDown();
                System.out.println(Thread.currentThread().getName() + " has reduced latch count. Current count: " + latch.getCount());
            }
        }
    }
}
