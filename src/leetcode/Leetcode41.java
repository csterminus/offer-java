package leetcode;

import java.util.*;

//缺失的第一个正数
public class Leetcode41 {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 1;
        }
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0 && nums[i] <= nums.length){
                res[nums[i] - 1] = nums[i];
            }
        }
        for(int i = 0; i < res.length; i++){
            if(res[i] != i + 1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        Leetcode41 leetcode41 = new Leetcode41();
        leetcode41.firstMissingPositive(new int[]{1,2,0});
    }
}
