package juc;

import java.util.concurrent.*;

//Future使用
public class FutureDemo {
    public static void main(String[] args) {
        FutureDemo testFuture = new FutureDemo();
        testFuture.future();
    }

    public void future() {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Double> future = executor.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                return doSomethingComputation();
            }
        });
        doSomethingElse();
        try {
            Double result = future.get(1, TimeUnit.SECONDS);
            System.out.println("result is" + result);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    private void doSomethingElse() {
        System.out.println("doSomethingElse");
    }

    private double doSomethingComputation() {
        System.out.println("doSomethingComputation");
        return 0.1;
    }

}
