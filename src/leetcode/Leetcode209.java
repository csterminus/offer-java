package leetcode;

public class Leetcode209 {
    //长度最小的子数组，找出该数组中满足其和 ≥ target 的长度最小的 连续子数组
    public static void main(String[] args) {
        Leetcode209 leetcode209 = new Leetcode209();
        int[] nums = new int[]{10,2,3};
        int target = 6;
        System.out.println(leetcode209.minSubArrayLen(target,nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int minCount = Integer.MAX_VALUE;
        for(int i = 0;i < nums.length;i++){
            int left = i;
            int right = nums.length - 1;
            int count = 0;
            int sum = 0;
            while(left <= right){
                sum = sum + nums[left];
                if(sum >= target){
                    count = left - i + 1;
                    if(count <= minCount){
                        minCount = count;
                    }
                    break;
                }
                left++;
            }
        }
        if(minCount == Integer.MAX_VALUE){
            return 0;
        }
        return minCount;
    }
}
