package leetcode;

/**
 * @author chengshi
 * @date 2024/5/17 15:29
 */
public class Leetcode34 {
    public static void main(String[] args) {
        Leetcode34 leetcode34 = new Leetcode34();
        leetcode34.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }

    public int[] searchRange(int[] nums, int target) {
        //我们可以使用二分查找分别找出目标值的开始位置和结束位置。以下是具体实现步骤：
        //
        //使用二分查找找到目标值的最左边界。
        //使用二分查找找到目标值的最右边界。
        int firstIndex = findLeft(nums, target);
        int lastIndex = findRight(nums, target);
        if (firstIndex <= lastIndex && firstIndex < nums.length && nums[firstIndex] == target) {
            return new int[]{firstIndex, lastIndex};
        }
        return new int[]{-1, -1};
    }

    private int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
