package leetcode;

import java.util.Arrays;

/**
 * @author chengshi
 * @date 2024/5/21 16:56
 */
public class Leetcode611 {
    public static void main(String[] args) {

    }

    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                int sum = nums[i] + nums[j];
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (sum > nums[mid]) {
                        left = mid + 1;
                    } else if (sum < nums[mid]) {
                        right = mid - 1;
                    } else {
                        right = mid - 1;
                    }
                }
                // 计算 [ j + 1 , right ] 这个区间中所有的元素
                if (sum > nums[right]) {
                    count = count + right - (j + 1) + 1;
                }
            }
        }
        return count;
    }
}
