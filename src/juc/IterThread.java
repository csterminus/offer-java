package juc;

/**
 * @author chengshi
 * @date 2024/5/16 16:37
 */
public class IterThread {
    private static final Object lock = new Object();
    private static int count = 1;
    private static int threadCount = 1;

    public static void main(String[] args) {
        Thread task1 = new Thread(new Task(1));
        Thread task2 = new Thread(new Task(2));
        Thread task3 = new Thread(new Task(3));
        task1.start();
        task2.start();
        task3.start();
    }

    static class Task implements Runnable {
        private final int threadNumber;

        public Task(int threadNumber) {
            this.threadNumber = threadNumber;
        }

        @Override
        public void run() {
            synchronized (lock) {
                while (count <= 75) {
                    if (threadCount == threadNumber) {
                        for (int i = 0; i < 5; i++) {
                            if (count > 75) {
                                break;
                            }
                            System.out.println(Thread.currentThread().getName() + ":" + count);
                            count++;
                        }
                        if (threadCount == 3) {
                            threadCount = 1;
                        } else {
                            threadCount++;
                        }
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
