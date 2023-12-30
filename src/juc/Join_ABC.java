package juc;

//join方式打印ABC
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
}
