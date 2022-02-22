package offer;

import java.util.PriorityQueue;

public class offer41 {
    //数据流中的中位数
    /**解题思路
     * 用两个堆保存数据，保证两个堆的数据保持平衡（元素个数相差不超过1）大顶堆存放的数据要比小顶堆的数据小，当两个堆中元素为偶数个，
     * 将新加入元素加入到大顶堆，如果要加入的数据，比小顶堆的最小元素大，先将该元素插入小顶堆，然后将小顶堆的最小元素插入到大顶堆。
     * 当两个堆中元素为奇数个，将新加入元素加入到小顶堆，如果要加入的数据，比大顶堆的最大元素小，先将该元素插入大顶堆，
     * 然后将大顶堆的最大元素插入到小顶堆。
     */
    //大顶堆存储左半边
    private PriorityQueue<Integer> left = new PriorityQueue<>();
    //小顶堆存储右边边
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    private int n = 0;
    public void Insert(Integer val){
        //插入要保证两个堆存于平衡状态
        if(n % 2 == 0){
            /* N 为偶数的情况下插入到右半边。
             * 因为右半边元素都要大于左半边，但是新插入的元素不一定比左半边元素来的大，
             * 因此需要先将元素插入左半边，然后利用左半边为大顶堆的特点，取出堆顶元素即为最大元素，此时插入右半边 */
        left.add(val);
        right.add(left.poll());
        }else {
            right.add(val);
            left.add(right.poll());
        }
        n ++;
    }
    public Double getMedian(){
        if(n % 2 == 0)
            return (left.peek() + right.peek()) / 2.0;
        else
            return (double)right.peek();
    }

}
