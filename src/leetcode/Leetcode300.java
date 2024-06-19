package leetcode;

import java.util.Arrays;

/**
 * @author chengshi
 * @date 2024/6/19 11:21
 */
public class Leetcode300 {
    public static void main(String[] args) {
        Leetcode300 leetcode300 = new Leetcode300();
        int[] nums = new int[]{4, 10, 4, 3, 8, 9};
        System.out.println(leetcode300.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                if (maxLength < dp[i]) {
                    maxLength = dp[i];
                }
                System.out.println(dp[i]);
            }
        }
        return maxLength;
    }

    //二分
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //数组存储当前最小的递增子序列的最后一个元素
        int[] dp = new int[nums.length];
        int length = 0;
        //遍历数组 nums，通过二分查找找到 dp 中第一个大于等于 nums[i] 的位置 pos，将 dp[pos] 更新为 nums[i]
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, length, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            //如果 pos 等于当前 dp 数组的长度，则增加 dp 数组的长度
            if (i == length) {
                length++;
            }
        }

        return length;
    }
}
