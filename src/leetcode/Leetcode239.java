package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chengshi
 * @date 2024/4/25 17:38
 */
//滑动窗口的最大值
public class Leetcode239 {
    public static void main(String[] args) {
        Leetcode239 leetcode239 = new Leetcode239();
        int[] nums = new int[]{7, 2, 4};
        leetcode239.maxSlidingWindow(nums, 2);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0;i < nums.length ;i++){
            while(!deque.isEmpty() && deque.peekFirst() < i - k + 1){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i >= k - 1){
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
