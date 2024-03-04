package juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chengshi
 * @date 2024/3/4 15:37
 */
public class SemaphoreDemo1 {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(50);

        for (int i = 0; i < 1000; i++) {

            service.submit(new Task());

        }

        service.shutdown();

    }

    static class Task implements Runnable {

        @Override

        public void run() {

            System.out.println(Thread.currentThread().getName() + "调用了慢服务");

            try {

                //模拟慢服务

                Thread.sleep(3000);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }
}
