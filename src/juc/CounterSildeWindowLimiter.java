package juc;

//滑动窗口
public class CounterSildeWindowLimiter {
    private int windowSize;//窗口大小，毫秒为单位

    private int limit;//窗口内限流大小

    private int splitNum;//切分小窗口的数目大小

    private int[] counters;//每个小窗口的计数数组

    private int index;//当前小窗口计数器的索引

    private long startTime;//窗口的开始时间


}
