package juc;

public class Wait_Notify_AB {

    public static final Object object = new Object();
    public static boolean printA = true;

    public void test() {
        ThreadA threadA = new ThreadA();
        threadA.start();
        ThreadB threadB = new ThreadB();
        threadB.start();
    }

    class ThreadA extends Thread{
        @Override
        public void run(){
                synchronized (Wait_Notify_AB.object){
                    if(!Wait_Notify_AB.printA){
                        try{
                            Wait_Notify_AB.object.wait();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("A");
                        Wait_Notify_AB.printA = false;
                        Wait_Notify_AB.object.notify();
                    }
            }
        }
    }

    class ThreadB extends Thread{
        @Override
        public void run(){
                synchronized (Wait_Notify_AB.object){
                    if(Wait_Notify_AB.printA){
                        try{
                            Wait_Notify_AB.object.wait();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("B");
                        Wait_Notify_AB.printA = true;
                        Wait_Notify_AB.object.notify();
                    }
                }
        }
    }

    public static void main(String[] args) {
        Wait_Notify_AB wait_notify_ab = new Wait_Notify_AB();
        wait_notify_ab.test();
    }

}
