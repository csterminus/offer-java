package limit;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author chengshi
 * @date 2024/4/24 10:23
 */
public class LeakyBucketLimiter {
    private int capaticy;//漏斗容量
    private int rate;//漏斗速率
    private ConcurrentLinkedQueue<Request> bucket;

    private LeakyBucketLimiter() {
    }
    //漏斗算法的原理也很容易理解。请求来了之后会首先进到漏斗里，然后漏斗以恒定的速率将请求流出进行处理，从而起到平滑流量的作用。
    // 当请求的流量过大时，漏斗达到最大容量时会溢出，此时请求被丢弃。从系统的角度来看，我们不知道什么时候会有请求来，
    // 也不知道请求会以多大的速率来，这就给系统的安全性埋下了隐患。但是如果加了一层漏斗算法限流之后，就能够保证请求以恒定的速率流出。在系统看来，
    // 请求永远是以平滑的传输速率过来，从而起到了保护系统的作用。

    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //漏桶的漏出速率是固定的，可以起到整流的作用。即虽然请求的流量可能具有随机性,忽大忽小，但是经过漏斗算法之后，变成了有固定速率的稳定流量，从而对下游的系统起到保护作用。
    //不能解决流量突发的问题。还是拿刚刚测试的例子，我们设定的漏斗速率是2个/秒，然后突然来了10个请求，受限于漏斗的容量，只有5个请求被接受，
    // 另外5个被拒绝。你可能会说，漏斗速率是2个/秒，然后瞬间接受了5个请求，这不就解决了流量突发的问题吗？不，这5个请求只是被接受了，但是没有马上被处理，
    // 处理的速度仍然是我们设定的2个/秒，所以没有解决流量突发的问题。而接下来我们要谈的令牌桶算法能够在一定程度上解决流量突发的问题，读者可以对比一下。

    public LeakyBucketLimiter(int capaticy, int rate) {
        this.bucket = new ConcurrentLinkedQueue<>();
        this.capaticy = capaticy;
        this.rate = rate;
        Thread thread = new Thread(this::leak);
        thread.start();
    }

    public static void main(String[] args) {
        LeakyBucketLimiter leakyBucketLimiter = new LeakyBucketLimiter(5, 1000);
        for (int i = 1; i <= 100; i++) {
            Request request = new Request("request" + i);
            leakyBucketLimiter.handleRequest(request);

        }
    }

    private void leak() {
        while (true) {
            if (!bucket.isEmpty()) {
                Request request = bucket.poll();
                System.out.println(request.getRequestId());
            }
            try {
                Thread.sleep(rate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleRequest(Request request) {
        if (bucket.size() < capaticy) {
            bucket.add(request);
        } else {
            System.out.println("bucket is full");
        }
    }


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

}
