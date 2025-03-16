package threadpool;

/**
 * @author chengshi
 * @date 2024/7/12 10:31
 */
public interface RunnableQueue {
    void offer(Runnable runnable);

    Runnable take() throws InterruptedException;

    int size();
}
