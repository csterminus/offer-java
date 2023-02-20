package juc;

import java.util.concurrent.Semaphore;

public class SemaphoreABC {

    private static Semaphore s1 = new Semaphore(1);

    private static Semaphore s2 = new Semaphore(0);

    private static Semaphore s3 = new Semaphore(0);

    private void printABC(Semaphore currentThread,Semaphore nextThread){
        for(int i = 0;i < 10;i++){
            try{
                currentThread.acquire();//阻塞当前线程，即信号量的计数器减1为0
                System.out.println(Thread.currentThread().getName());
                nextThread.release();//唤醒下一个线程，即信号量的计数器加1
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        SemaphoreABC printer = new SemaphoreABC();
        new Thread(() -> {
            printer.printABC(s1,s2);
        },"A").start();
        Thread.sleep(10);
        new Thread(() -> {
            printer.printABC(s2,s3);
        },"B").start();
        Thread.sleep(10);
        new Thread(() ->{
            printer.printABC(s3,s1);
        },"C").start();
    }
}
