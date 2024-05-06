package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chengshi
 * @date 2024/4/25 17:38
 */
public class Leetcode239 {
    public static void main(String[] args) {
        Leetcode239 leetcode239 = new Leetcode239();
        int[] nums = new int[]{7, 2, 4};
        leetcode239.maxSlidingWindow(nums, 2);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] res = new int[nums.length - k + 1];
        int count = 0;
        if (nums.length == 1 || k == 1) {
            return nums;
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.removeLast();
            }
            queue.offerLast(nums[i]);
        }
        res[count++] = queue.peekFirst();
        for (int j = k; j < nums.length; j++) {
            if (nums[j - k] == queue.peekFirst()) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && queue.peekLast() < nums[j]) {
                queue.removeLast();
            }
            queue.offerLast(nums[j]);
            res[count++] = queue.peekFirst();
        }
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
        return res;
    }
}
