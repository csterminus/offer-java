package juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HorseRaceSimulation {

    private static final int NUM_HORSES = 10;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch readyLatch = new CountDownLatch(NUM_HORSES);
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch finishLatch = new CountDownLatch(NUM_HORSES);

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_HORSES);

        for (int i = 0; i < NUM_HORSES; i++) {
            final int horseNumber = i + 1;
            executorService.submit(() -> {
                try {
                    System.out.println("Horse " + horseNumber + " is getting ready.");
                    readyLatch.countDown();
                    startLatch.await(); // Wait for the start signal
                    System.out.println("Horse " + horseNumber + " is running.");
                    // Simulate running time
                    TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
                    System.out.println("Horse " + horseNumber + " has finished.");
                    finishLatch.countDown();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Wait for all horses to be ready
        readyLatch.await();
        System.out.println("All horses are ready. Starting the race!");
        startLatch.countDown(); // Start the race

        // Wait for all horses to finish
        finishLatch.await();
        System.out.println("All horses have finished. Announcing results.");

        executorService.shutdown();
    }
}
