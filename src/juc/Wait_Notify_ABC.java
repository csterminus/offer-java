package juc;

/**
 * 多线程打印ABC
 */
public class Wait_Notify_ABC {

    private int num;

    private static final Object lock = new Object();

    private void printABC(int targetNum){
        for(int i = 0;i < 10;i++){
            synchronized (lock){
                while(num % 3 != targetNum){
                    try{
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                num++;
                System.out.println(Thread.currentThread().getName());
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Wait_Notify_ABC wait_notify_abc = new Wait_Notify_ABC();
        new Thread(() ->{
            wait_notify_abc.printABC(0);
        },"A").start();
        new Thread(() ->{
            wait_notify_abc.printABC(1);
        },"B").start();
        new Thread(() -> {
            wait_notify_abc.printABC(2);
        },"C").start();
    }
}
