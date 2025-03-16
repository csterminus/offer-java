package threadpool;

/**
 * @author chengshi
 * @date 2024/7/12 10:42
 */
public class RunnableRejectException extends RuntimeException {
    public RunnableRejectException(String message) {
        super(message);
    }
}
