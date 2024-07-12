package threadpool;

/**
 * @author chengshi
 * @date 2024/7/12 11:03
 */
public interface ThreadFactory {

    Thread createThread(Runnable runnable);
}
