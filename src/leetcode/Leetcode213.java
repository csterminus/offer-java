package leetcode;

import java.util.Arrays;

public class Leetcode213 {
    //打家劫舍2
    public static void main(String[] args) {
        Leetcode213 leetcode213 = new Leetcode213();
        int[] nums = new int[]{1,2,3,1};
        System.out.println(leetcode213.rob(nums));
    }
    //拆成俩个环0 - n-1 , 1 - n
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums[0];
        }
        int[] dp = new int[n];
        // 第一家不偷, 最后一家偷
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        int max = dp[n - 1];
        // 偷第一家, 不偷最后一家
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return Math.max(max, dp[n - 2]);
    }

}
