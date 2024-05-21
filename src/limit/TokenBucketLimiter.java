package limit;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author chengshi
 * @date 2024/4/24 10:52
 */
public class TokenBucketLimiter {
    //令牌桶算法是对漏斗算法的一种改进，除了能够起到限流的作用外，还允许一定程度的流量突发。
    // 在令牌桶算法中，存在一个令牌桶，算法中存在一种机制以恒定的速率向令牌桶中放入令牌。
    // 令牌桶也有一定的容量，如果满了令牌就无法放进去了。
    // 当请求来时，会首先到令牌桶中去拿令牌，如果拿到了令牌，则该请求会被处理，并消耗掉拿到的令牌；如果令牌桶为空，则该请求会被丢弃。
    //令牌桶算法是对漏桶算法的一种改进，除了能够在限制调用的平均速率的同时还允许一定程度的流量突发
    private int capacity;//令牌桶容量
    private long rate;//令牌产生速率 毫秒
    private ArrayBlockingQueue<Token> bucket;//令牌数量

    public TokenBucketLimiter(int capacity, int rate) {
        this.capacity = capacity;
        this.rate = rate;
        this.bucket = new ArrayBlockingQueue<>(capacity);
        for (int i = 0; i < capacity; i++) {
            bucket.add(new Token());
        }
        Thread thread = new Thread(this::produceToken);
        thread.start();
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucketLimiter tokenBucketLimiter = new TokenBucketLimiter(5, 1000);
        for (int i = 1; i <= 10; i++) {
            Request request = new Request("request" + i);
            Thread.sleep(100);
            if (tokenBucketLimiter.processRequest(request)) {
                System.out.println(i + "号请求被接受");
            } else {
                System.out.println(i + "号请求被拒绝");
            }
        }
    }

    public boolean processRequest(Request request) {
        Token token = bucket.poll();
        if (token != null) {
            System.out.println("Request" + request.getRequestId() + "processed.");
            return true;
        } else {
            System.out.println("No token available,request" + request.getRequestId() + "rejected!");
            return false;
        }
    }

    private void produceToken() {
        while (true) {
            if (bucket.size() < capacity) {
                bucket.add(new Token());
            }
            try {
                Thread.sleep(rate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 请求类，属性只包含一个名字字符串
     */
    public static class Request {
        private String requestId;
        private Long timestamp;

        public Request(String requestId) {
            this.requestId = requestId;
            this.timestamp = System.currentTimeMillis();
        }

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public Long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }
    }

    public static class Token {

    }

}
