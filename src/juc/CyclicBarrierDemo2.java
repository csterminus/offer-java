package juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author chengshi
 * @date 2024/7/11 17:04
 */
public class CyclicBarrierDemo2 {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println("一批任务执行完成");
            }
        });
        for (int i = 0; i < 10; i++) {
            new Thread(new Task("task" + i, cyclicBarrier)).start();
        }
    }

    static class Task implements Runnable {

        private String id;

        private CyclicBarrier cyclicBarrier;

        public Task(String id, CyclicBarrier cyclicBarrier) {
            this.id = id;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep((long) (Math.random() * 1000));
                    System.out.println(id + i);
                    cyclicBarrier.await();
                }
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
