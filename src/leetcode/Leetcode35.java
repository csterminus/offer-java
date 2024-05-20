package leetcode;

/**
 * @author chengshi
 * @date 2024/5/17 14:18
 */
public class Leetcode35 {
    public static void main(String[] args) {
        Leetcode35 leetcode35 = new Leetcode35();
        leetcode35.searchInsert(new int[]{1, 3}, 2);
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return left;
    }
}
