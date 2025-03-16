package juc;

public class Wait_Notify_AB {

    public static final Object object = new Object();
    public static boolean printA = true;

    public static void main(String[] args) {
        Wait_Notify_AB wait_notify_ab = new Wait_Notify_AB();
        wait_notify_ab.test();
    }

    public void test() {
        ThreadA threadA = new ThreadA();
        threadA.start();
        ThreadB threadB = new ThreadB();
        threadB.start();
    }

    class ThreadA extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                while (true) {
                    if (!printA) {
                        try {
                            object.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("A");
                        printA = false;
                        object.notify();
                    }
                }
            }
        }
    }

    class ThreadB extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                while (true) {
                    if (printA) {
                        try {
                            object.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("B");
                        printA = true;
                        object.notify();
                    }
                }
            }
        }
    }

}
