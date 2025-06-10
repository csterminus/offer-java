package leetcode;

public class Leetcode283 {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        if(nums.length == 1){
            return;
        }
        int left = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 0){
                continue;
            }else{
                nums[left] = nums[i];
                left++;
            }
        }
        for(int i = left;i < nums.length;i ++){
            nums[i] = 0;
        }
    }
}
