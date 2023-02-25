package leetcode;

public class Leetcode704 {
    //二分查找
    public static void main(String[] args) {
        Leetcode704 leetcode704 = new Leetcode704();
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 9;
        System.out.println(leetcode704.search(nums,target));
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
