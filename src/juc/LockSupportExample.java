package juc;

import java.util.concurrent.locks.LockSupport;

//对应 wait notify
public class LockSupportExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Thread is going to park");
            LockSupport.park();
            System.out.println("Thread is unparked");
        });

        thread.start();

        // 让主线程休眠一段时间，以确保上面的线程已经进入park状态
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Unparking the thread");
        LockSupport.unpark(thread);
    }
}
