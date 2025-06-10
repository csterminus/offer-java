package leetcode;

/**
 * @author chengshi
 * @date 2024/5/12 16:06
 */
public class Interview16 {
    public static void main(String[] args) {

    }
    // 找出数组中最小的和最大的元素，然后分别向左向右扫描找到这两个元素的边界
    public int[] subSort(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return new int[]{-1, -1};
        }
        int min = nums[nums.length - 1];
        int m = -1;
        for (int j = nums.length - 2; j >= 0; j--) {
            if (nums[j] < min) {
                min = nums[j];
            } else {
                m = j;
            }
        }
        int max = nums[0];
        int n = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } else {
                n = i;
            }
        }
        return new int[]{m, n};
    }
}
