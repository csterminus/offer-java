package juc;

//修饰静态方法
//当 synchronized 修饰静态方法时，它锁定的是调用该方法的类的 Class 对象。
// 这意味着，同一时刻只有一个线程可以执行该类的该同步静态方法。
public class SynchronizedStaticMethod {
    private static int count = 0;

    public static synchronized void increment() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void main(String[] args) {
        // 创建多个线程来并发地修改计数器
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                SynchronizedStaticMethod.increment();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                SynchronizedStaticMethod.increment();
            }
        });

        // 启动线程
        thread1.start();
        thread2.start();

        // 等待线程执行完毕
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 输出最终的计数器值
        System.out.println("Final count: " + SynchronizedStaticMethod.getCount());
    }
}
