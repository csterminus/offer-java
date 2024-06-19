package leetcode;

/**
 * @author chengshi
 * @date 2024/6/19 11:21
 */
public class Leetcode674 {
    public static void main(String[] args) {
        Leetcode674 leetcode300 = new Leetcode674();
        int[] nums = new int[]{1, 3, 5, 4, 7};
        System.out.println(leetcode300.findLengthOfLCIS(nums));
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                max = dp[i] > max ? dp[i] : max;
            } else {
                dp[i] = 1;
            }
            System.out.println(dp[i]);
        }
        return max;
    }
}
