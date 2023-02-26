package leetcode;

public class Leetcode198 {
    //打家劫舍1
    public static void main(String[] args) {
        Leetcode198 leetcode198 = new Leetcode198();
        int[] nums = new int[]{2,10,5};
        System.out.println(leetcode198.rob(nums));
    }

    public int rob (int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2;i < nums.length;i++){
            dp[i] = Math.max(nums[i] + dp[i - 2],dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
