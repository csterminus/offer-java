package juc;

public class Lock2Singleton {
    private volatile static Lock2Singleton instance;

    private Lock2Singleton(){

    }

    public static Lock2Singleton getSingleton(){
        if(instance == null){
            synchronized (Lock2Singleton.class){
                if(instance == null){
                    instance = new Lock2Singleton();
                }
            }
        }
        return instance;
    }
}
