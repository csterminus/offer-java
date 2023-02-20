package juc;

public class Join_ABC {

    static class printABC implements Runnable{

        private Thread beforeThread;

        public printABC(Thread beforeThread){
            this.beforeThread = beforeThread;
        }

        @Override
        public void run() {
            if(beforeThread != null){
                try {
                    beforeThread.join();
                    System.out.println(Thread.currentThread().getName());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else {
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        for(int i = 0;i < 10; i++){
            Thread t1 = new Thread(new printABC(null),"A");
            Thread t2 = new Thread(new printABC(t1),"B");
            Thread t3 = new Thread(new printABC(t2),"C");
            t1.start();
            t2.start();
            t3.start();
            Thread.sleep(10);
        }
    }
}
