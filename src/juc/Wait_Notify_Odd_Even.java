package juc;

public class Wait_Notify_Odd_Even {

    private static final Object monitor = new Object();

    private volatile int count;

    Wait_Notify_Odd_Even(int initCount) {
        this.count = initCount;
    }

    public static void main(String[] args) throws InterruptedException {
        Wait_Notify_Odd_Even wait_notify_odd_even = new Wait_Notify_Odd_Even(0);
        new Thread(() -> {
            wait_notify_odd_even.printOddEven();
        }, "odd").start();
        Thread.sleep(100);
        new Thread(() -> {
            wait_notify_odd_even.printOddEven();
        }, "even").start();
    }

    private void printOddEven() {
        synchronized (monitor) {
            while (count <= 100) {
                try {
                    System.out.print(Thread.currentThread().getName() + ":");
                    System.out.println(count++);
                    monitor.notifyAll();
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            monitor.notifyAll();
        }
    }
}
