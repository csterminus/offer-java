package leetcode;

//计算除当前元素的所有乘积
public class Leetcode238 {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        int[] res = new int[nums.length];
        int left = 1;
        for(int i = 0;i < nums.length;i++){
            res[i] = left;
            left = left * nums[i];
        }
        int right = 1;
        for(int i = nums.length - 1;i >= 0;i++){
            res[i] = res[i] * right;
            right = right * nums[i];
        }
        return res;
    }
}
