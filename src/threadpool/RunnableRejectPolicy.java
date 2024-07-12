package threadpool;

/**
 * @author chengshi
 * @date 2024/7/12 10:36
 */
@FunctionalInterface
public interface RunnableRejectPolicy {

    void reject(Runnable runnable, ThreadPool threadPool);

    class DiscardRejectPolicy implements RunnableRejectPolicy {

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            System.out.println(runnable + "不做处理");
        }
    }

    class AbortRejectPolicy implements RunnableRejectPolicy {

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            throw new RunnableRejectException("The" + runnable + "will be abort");
        }
    }

    class RunnerRejectPolicy implements RunnableRejectPolicy {

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            if (threadPool.isShutdown()) {
                runnable.run();
            }
        }
    }
}
