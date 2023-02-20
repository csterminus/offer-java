package leetcode;

public class Leetcode977 {
    public static void main(String[] args) {
        Leetcode977 leetcode977 = new Leetcode977();
        int[] nums = new int[]{-4,-1,0,3,10};
        leetcode977.sortedSquares(nums);
    }

    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int l = 0;
        int r = nums.length - 1;
        int j = nums.length - 1;
        while (l <= r){
            if(nums[l] * nums[l] > nums[r] * nums[r]){
                res[j--] = nums[l] * nums[l++];
            }else{
                res[j--] = nums[r] * nums[r--];
            }
        }
        return res;
    }
}
