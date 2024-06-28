package leetcode;

/**
 * @author chengshi
 * @date 2024/6/19 15:43
 */
public class Leetcode494 {
    private int count = 0;

    public static void main(String[] args) {
        Leetcode494 leetcode494 = new Leetcode494();
        int[] nums = new int[]{100};
        leetcode494.findTargetSumWays(nums, -200);
    }


    //可以将问题转换为一个子集和的问题来解决。所有符号为+的元素和为x，符号为-的元素和的绝对值是y。所以说我们能够得出：x-y=target, x+y=sum(nums)
    //p - n = target  p + n = sum(nums) p = target + sum(nums) / 2
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        if (sum < Math.abs(target) || (sum + target) % 2 != 0) {
            return 0;
        }
        int p = Math.abs((sum + target) / 2);
        int[] dp = new int[p + 1];
        dp[0] = 1;
        //当前填满容量为j的包的方法数 = 之前填满容量为j的包的方法数 + 之前填满容量为j - num的包的方法数 也就是当前数num的加入，可以把之前和为j - num的方法数加入进来
        for (int i = 0; i < nums.length; i++) {
            for (int j = p; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
                System.out.println(dp[j]);
            }
        }
        return dp[p];
    }
}
