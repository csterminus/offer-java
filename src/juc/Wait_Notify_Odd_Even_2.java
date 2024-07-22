package juc;

/**
 * @author chengshi
 * @date 2024/6/11 16:38
 */
public class Wait_Notify_Odd_Even_2 {
    private static final Object obj = new Object();
    private static int count = 1;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task());
        Thread thread2 = new Thread(new Task2());
        thread1.start();
        thread2.start();
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            while (count <= 100) {
                synchronized (obj) {
                    while (count % 2 != 0) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (count <= 100) {
                        System.out.println(count + Thread.currentThread().getName());
                        count++;
                        obj.notifyAll();
                    }
                }
            }
        }
    }

    static class Task2 implements Runnable {
        @Override
        public void run() {
            while (count <= 100) {
                synchronized (obj) {
                    while (count % 2 == 0) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (count <= 100) {
                        System.out.println(count + Thread.currentThread().getName());
                        count++;
                        obj.notifyAll();
                    }
                }
            }
        }
    }
}
