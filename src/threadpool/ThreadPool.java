package threadpool;

/**
 * @author chengshi
 * @date 2024/7/12 10:29
 */
public interface ThreadPool {

    void execute(Runnable runnable);

    void shutdown();

    int getInitSize();

    int getMaxSize();

    int getCoreSize();

    int getQueueSize();

    int getActiveCount();

    boolean isShutdown();
}
