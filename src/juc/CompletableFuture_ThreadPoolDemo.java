package juc;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chengshi
 * @date 2024/3/4 14:55
 */
public class CompletableFuture_ThreadPoolDemo {
    ExecutorService threadPool = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture_ThreadPoolDemo completableFuture_threadPoolDemo = new CompletableFuture_ThreadPoolDemo();
        System.out.println(completableFuture_threadPoolDemo.getPrice());
    }

    private Set<Integer> getPrice() throws InterruptedException {
        Set<Integer> prices = Collections.synchronizedSet(new HashSet<Integer>());
        threadPool.submit(new Task(123, prices));
        threadPool.submit(new Task(456, prices));
        threadPool.submit(new Task(789, prices));
        Thread.sleep(3000);
        return prices;
    }

    private class Task implements Runnable {
        Integer productId;
        Set<Integer> prices;

        public Task(Integer productId, Set<Integer> prices) {
            this.productId = productId;
            this.prices = prices;
        }

        @Override
        public void run() {
            int price = 0;
            try {
                Thread.sleep((long) (Math.random() * 4000));
                price = (int) (Math.random() * 4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            prices.add(price);
        }
    }
}
