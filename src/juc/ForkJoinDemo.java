package juc;

/**
 * @author chengshi
 * @date 2024/6/13 16:44
 */

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo {

    public static void main(String[] args) {
        // Create a large array of integers
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        // Create a ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();

        // Create a task to sum the array
        SumTask task = new SumTask(array, 0, array.length);

        // Execute the task in the ForkJoinPool
        Integer result = pool.invoke(task);

        // Print the result
        System.out.println("Sum of array: " + result);
    }
}

class SumTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 100; // Threshold for splitting tasks
    private int[] array;
    private int start;
    private int end;

    public SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
            // If the task is small enough, compute directly
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            // Split the task into two smaller tasks
            int mid = (start + end) / 2;
            SumTask leftTask = new SumTask(array, start, mid);
            SumTask rightTask = new SumTask(array, mid, end);

            // Fork the subtasks
            leftTask.fork();
            rightTask.fork();

            // Join the results of the subtasks
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            // Combine the results
            return leftResult + rightResult;
        }
    }
}

