package threadpool;

import java.util.LinkedList;
import java.util.List;

/**
 * @author chengshi
 * @date 2024/7/12 11:25
 */
public class MyThreadPool {
    private final int nThreads;

    private final List<Worker> workers;

    private final LinkedList<Runnable> taskQueue;

    public MyThreadPool(int nThreads) {
        this.nThreads = nThreads;
        taskQueue = new LinkedList<>();
        workers = new LinkedList<>();
        for (int i = 0; i < nThreads; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            worker.start();
        }
    }

    public void execute(Runnable task) {
        synchronized (taskQueue) {
            taskQueue.add(task);
            taskQueue.notify();
        }
    }

    private class Worker extends Thread {
        @Override
        public void run() {
            Runnable task;
            while (true) {
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty()) {
                        try {
                            taskQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task = taskQueue.removeFirst();
                }
                try {
                    task.run();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
