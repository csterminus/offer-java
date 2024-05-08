package leetcode;

import java.util.PriorityQueue;

/**
 * @author chengshi
 * @date 2024/5/8 14:22
 */
public class Leetcode295 {
    //1、大顶堆从左到右递增
    //2、小顶堆从左到右递增
    //1、当两堆长度相等，即长度都为 n 时，新数据加入到小顶堆中，使得小顶堆的长度为 n + 1，那么证两个堆的长度相差 1，小顶堆的堆顶就是中位数。
    //2、当两堆长度不相等，即小顶堆长度为 n，大顶堆长度为 n – 1，新数据加入到大顶堆中，使得大顶堆的长度为 n ，那么两个堆的长度就相等，两个堆的堆顶相加除二就是中位数。
    //1）、如果两堆长度相等，即长度都为 n 时，新数据先加入到大顶堆中，然后再把大顶堆的堆顶元素取出，放入到小顶堆中。
    //2）、当两堆长度不相等，即小顶堆长度为 n，大顶堆长度为 n – 1，新数据先加入到小顶堆中，然后再把小顶堆的堆顶元素取出，放入到大顶堆中

    public static void main(String[] args) {

    }

    class MedianFinder {
        PriorityQueue<Integer> maxHeap;

        PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            maxHeap = new PriorityQueue<Integer>((x, y) -> (y - x));
            minHeap = new PriorityQueue<Integer>();
        }

        public void addNum(int num) {
            if (maxHeap.size() != minHeap.size()) {
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
            } else {
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() != minHeap.size()) {
                return minHeap.peek();
            } else {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
        }
    }
}
