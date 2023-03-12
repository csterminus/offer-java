package leetcode;

public class Leetcode153 {
    //寻找旋转排序数组中的最小值
    public static void main(String[] args) {
        Leetcode153 leetcode153 = new Leetcode153();
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(leetcode153.findMin(nums));
    }
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
             //LR相邻时，最小值只存在于LR之间
            if(right - left == 1){
                break;
            }
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[right] && nums[mid] > nums[left]){//中间值介于两者之间，则说明此时已按顺序排列，最小值就是L
                break;
            }else if(nums[mid] > nums[right] && nums[mid] > nums[left]){  //中间值大于两端，则说明最小值在右侧
                left = mid ;
            }else if(nums[mid] < nums[left] && nums[mid] < nums[right]){  //中间值小于两端，则说明最小值在左侧
                right = mid;
            }
        }
        return Math.min(nums[left],nums[right]);
    }
}
