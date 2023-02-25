package leetcode;

import java.util.Arrays;

public class Leetcode27 {
    //给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度
    public static void main(String[] args) {
        Leetcode27 leetcode27 = new Leetcode27();
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(leetcode27.removeElement(nums,val));
    }

    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int slow = 0;
        for(int fast = 0;fast < nums.length;fast++){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
