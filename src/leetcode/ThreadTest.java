package leetcode;

public class ThreadTest {
    private static final Object lock = new Object();
    private static int count = 1;
    private static int countNum = 1;
    public static void main(String[] args) {
        Thread task1 = new Thread(new Task(1));
        Thread task2 = new Thread(new Task(2));
        Thread task3 = new Thread(new Task(3));
        task1.start();
        task2.start();
        task3.start();
    }

    public static class Task implements Runnable {
        private final int threadNum;

        public Task(int threadNum) {
            this.threadNum = threadNum;
        }

        public void run() {
            try {
                synchronized (lock) {
                while (count <= 75) {
                        if (threadNum == countNum) {
                            for (int i = 0; i < 5; i++) {
                                if(count > 75){
                                    break;
                                }
                                System.out.println(count + "thread" + threadNum);
                                count++;
                            }
                            if (countNum != 3) {
                                countNum++;
                            } else {
                                countNum = 1;
                            }
                            lock.notifyAll();
                        }
                        else{
                            lock.wait();
                    }
                }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
