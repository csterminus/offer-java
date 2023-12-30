package juc;

import java.util.concurrent.atomic.AtomicInteger;
//计数器固定窗口
public class CounterLimiter {

    private int windowSize; //窗口大小

    private int limit;//窗口内限流大小

    private AtomicInteger count;//当前窗口计数器

    private CounterLimiter(){

    }

    public CounterLimiter(int windowSize,int limit){
        this.limit = limit;
        this.windowSize = windowSize;
        count = new AtomicInteger(0);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    count.set(0);
                    try {
                        Thread.sleep(windowSize);
                    }catch (InterruptedException exception){
                        exception.printStackTrace();
                    }
                }
            }
        }).start();
    }

    //请求先到达后调用本方法
    public boolean tryTest(){
        int newCount = count.addAndGet(1);
        if(newCount > limit){
            return false;
        }else {
            return true;
        }
    }

    //测试
    public static void main(String[] args) throws InterruptedException {
        //每秒20个请求
        CounterLimiter counterLimiter = new CounterLimiter(1000,20);
        int count = 0;
        //模拟50次请求，看多少能通过
        for(int i = 0;i < 50;i ++){
            if(counterLimiter.tryTest()){
                count ++;
            }
        }
        System.out.println("第一拨50次请求中通过：" + count + ",限流：" + (50 - count));
        //过一秒再请求
        Thread.sleep(1000);
        //模拟50次请求，看多少能通过
        count = 0;
        for(int i = 0;i < 50;i ++){
            if(counterLimiter.tryTest()){
                count ++;
            }
        }
        System.out.println("第二拨50次请求中通过：" + count + ",限流：" + (50 - count));
    }
    //缺点 一段时间内服务不可用 窗口切换时可能会产生两倍于阈值流量的请求
}
