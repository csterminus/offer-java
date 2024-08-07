package threadpool;


import java.util.LinkedList;

/**
 * @author chengshi
 * @date 2024/7/12 10:34
 */
public class LinkedRunnableQueue implements RunnableQueue {
    private final int limit;

    private final RunnableRejectPolicy rejectPolicy;

    private final LinkedList<Runnable> runnableLinkedList = new LinkedList<>();

    private final ThreadPool threadPool;

    public LinkedRunnableQueue(int limit, RunnableRejectPolicy rejectPolicy, ThreadPool threadPool) {
        this.limit = limit;
        this.rejectPolicy = rejectPolicy;
        this.threadPool = threadPool;
    }

    @Override

    public void offer(Runnable runnable) {
        synchronized (runnableLinkedList) {
            if (runnableLinkedList.size() >= limit) {
                System.out.println(runnableLinkedList.size() + " >= " + limit + " execute deny policy");
                rejectPolicy.reject(runnable, threadPool);
            } else {
                runnableLinkedList.addLast(runnable);
                runnableLinkedList.notifyAll();
            }
        }
    }

    @Override
    public Runnable take() throws InterruptedException {
        synchronized (runnableLinkedList) {
            while (runnableLinkedList.isEmpty()) {
                try {
                    runnableLinkedList.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
        }
        return runnableLinkedList.removeFirst();
    }

    @Override
    public int size() {
        synchronized (runnableLinkedList) {
            return runnableLinkedList.size();
        }
    }
}
