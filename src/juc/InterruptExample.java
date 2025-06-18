package juc;

public class InterruptExample{
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread is running...");
                    Thread.sleep(1000); // 模拟线程执行任务
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        });

        // 启动线程
        thread.start();

        // 主线程等待一段时间后中断子线程
        try {
            Thread.sleep(3000);
            thread.interrupt(); // 中断子线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void runTask() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                // 执行任务
                // ...

                // 假设这里有一个阻塞调用
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // 线程被中断时的处理
                System.out.println("任务被中断，正在清理资源...");

                // 清理资源
                // ...

                // 重新设置中断状态
                Thread.currentThread().interrupt();

                // 退出循环或者线程
                break;
            }
        }
    }
}
