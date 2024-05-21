package offer;

/**
 * @author chengshi
 * @date 2024/5/21 17:40
 */
public class offer53 {
    public static void main(String[] args) {

    }

    private int findNumber(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int firstIndex = findLeft(nums, target);
        int lastIndex = findRight(nums, target);
        if (firstIndex <= lastIndex && firstIndex < nums.length && nums[firstIndex] == target) {
            return lastIndex - firstIndex + 1;
        }
        return 0;
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

    private int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
