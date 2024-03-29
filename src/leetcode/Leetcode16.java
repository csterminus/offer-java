package leetcode;

import java.util.Arrays;

public class Leetcode16 {
    //最接近的三数之和，接近目标值
    public static void main(String[] args) {
        Leetcode16 leetcode16 = new Leetcode16();
        int[] nums = new int[]{0, 0, 0};
        int target = 1;
        System.out.println(leetcode16.threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int temp = nums[i] + nums[l] + nums[r];
                int newValue = target - temp;
                int oldValue = target - res;
                if (Math.abs(newValue) < Math.abs(oldValue)) {
                    res = temp;
                }
                if (newValue > 0) {
                    l++;
                } else if (newValue < 0) {
                    r--;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
