package limit;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chengshi
 * @date 2024/4/23 17:02
 */
public class CountLimit {
    private int windowSize; //窗口大小
    private int limit;//窗口内限流大小
    private AtomicInteger count;//当前窗口的计数器

    private CountLimit() {

    }

    public CountLimit(int windowSize, int limit) {
        this.limit = limit;
        this.windowSize = windowSize;
        count = new AtomicInteger(0);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    count.set(0);
                    try {
                        Thread.sleep(windowSize);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) throws InterruptedException {
        //每秒20个请求
        CountLimit counterLimiter = new CountLimit(1000, 20);
        int count = 0;
        //模拟50次请求，看多少能通过
        for (int i = 0; i < 50; i++) {
            if (counterLimiter.tryAcquire()) {
                count++;
            }
        }
        System.out.println("第一拨50次请求中通过：" + count + ",限流：" + (50 - count));
        //过一秒再请求
        Thread.sleep(1000);
        //模拟50次请求，看多少能通过
        count = 0;
        for (int i = 0; i < 50; i++) {
            if (counterLimiter.tryAcquire()) {
                count++;
            }
        }
        System.out.println("第二拨50次请求中通过：" + count + ",限流：" + (50 - count));
    }

    public boolean tryAcquire() {
        int newCount = count.addAndGet(1);
        if (newCount > limit) {
            return false;
        } else {
            return true;
        }
    }

    //特点分析
    //优点：实现简单，容易理解。
    //缺点：流量曲线可能不够平滑，有“突刺现象”，如下图所示。这样会有两个问题：
    //一段时间内（不超过时间窗口）系统服务不可用。比如窗口大小为1s，限流大小为100，然后恰好在某个窗口的第1ms来了100个请求，然后第2ms-999ms的请求就都会被拒绝，这段时间用户会感觉系统服务不可用。
    //窗口切换时可能会产生两倍于阈值流量的请求。比如窗口大小为1s，限流大小为100，然后恰好在某个窗口的第999ms来了100个请求，窗口前期没有请求，所以这100个请求都会通过。
    // 再恰好，下一个窗口的第1ms有来了100个请求，也全部通过了，那也就是在2ms之内通过了200个请求，而我们设定的阈值是100，通过的请求达到了阈值的两倍。

}
