package juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConsumerProducerWithBlockingQueue {

    public static void main(String[] args) {
        ConsumerProducerWithBlockingQueue consumerProducerWithBlockingQueue = new ConsumerProducerWithBlockingQueue();
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(10);
        Producer producer = consumerProducerWithBlockingQueue.new Producer(blockingQueue);
        Consumer consumer = consumerProducerWithBlockingQueue.new Consumer(blockingQueue);
        producer.start();
        consumer.start();
    }

    class Consumer extends Thread{
        private BlockingQueue<Object> queue;
        public Consumer(BlockingQueue queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            try{
                for(int i = 0;i <= 100;i++){
                    System.out.println("消费者取出：" + queue.take()+"仓库还有"+queue.size());
                }
            }catch (InterruptedException exception){
                exception.printStackTrace();
            }
        }
    }

    class Producer extends Thread{
        private BlockingQueue<Object> queue;
        public Producer(BlockingQueue queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            try{
                for(int i = 0;i <= 100;i++){
                    System.out.println("生产者放入："+i);
                    queue.put(i);
                }
            }catch (InterruptedException exception){
                exception.printStackTrace();
            }
        }
    }
}
