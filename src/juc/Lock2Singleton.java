package juc;

public class Lock2Singleton {
    private volatile static Lock2Singleton instance;

    private Lock2Singleton() {

    }

    /**
     * 使用 volatile 的意义主要在于它可以防止避免拿到没完成初始化的对象，从而保证了线程安全。 防止指令重排序
     * 第一步是给 singleton 分配内存空间；然后第二步开始调用 Singleton 的构造函数等，来初始化 singleton；最后第三步，将 singleton 对象指向分配的内存空间（执行完这步 singleton 就不是 null 了）。
     * 单例模式一个理由，那就是为了节省内存、节省计算、避免每次都重新生成实例 第二个理由保证结果正确
     *
     * @return
     */
    public static Lock2Singleton getSingleton() {
        if (instance == null) {
            synchronized (Lock2Singleton.class) {
                if (instance == null) {
                    instance = new Lock2Singleton();
                }
            }
        }
        return instance;
    }
}
