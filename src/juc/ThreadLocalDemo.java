package juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chengshi
 * @date 2024/7/24 17:51
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(2, 3, 0, TimeUnit.MILLISECONDS, new SynchronousQueue<>());
//        TransmittableThreadLocal<String> threadLocal = new TransmittableThreadLocal<>();
//        ExecutorService ttlExecutorService = TtlExecutors.getTtlExecutorService(executorService);
        try {
            InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
            threadLocal.set("thread-1");
            executorService.execute(() -> {
                String s = threadLocal.get();
                System.out.println(s);
            });
            Thread.sleep(100);
            threadLocal.set("thread-2");
            executorService.execute(() -> {
                String s = threadLocal.get();
                System.out.println(s);
            });
            Thread.sleep(100);
            threadLocal.set("thread-3");
            executorService.execute(() -> {
                String s = threadLocal.get();
                System.out.println(s);
            });
            Thread.sleep(100);
            threadLocal.set("thread-4");
            executorService.execute(() -> {
                String s = threadLocal.get();
                System.out.println(s);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
