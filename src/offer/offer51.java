package offer;

/**
 * @author chengshi
 * @date 2024/5/8 15:35
 */
public class offer51 {
    //求数组中的逆序数
    int count;

    public static void main(String[] args) {

    }

    public int reversePairs(int[] nums) {
        int count = 0;
        int[] res = new int[nums.length];
        mergeSortRecursive(nums, res, 0, nums.length - 1);
        return count;
    }

    public void mergeSortRecursive(int[] nums, int[] res, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        int start1 = start;
        int end1 = mid;
        int start2 = mid + 1;
        int end2 = end;

        mergeSortRecursive(nums, res, start1, end1);
        mergeSortRecursive(nums, res, start2, end2);
        int k = start;
        while (start1 < end1 && start2 < end2) {
            if (nums[start1] <= nums[start2]) {
                res[k] = nums[start1];
                start1++;
                k++;
            } else {
                res[k] = nums[start2];
                count = count + end1 - start1 + 1;
                start2++;
            }
        }
        // 如果左区间中还有元素，那么把它都添加到 result 中
        while (start1 <= end1) {
            res[k] = nums[start1];
            k++;
            start1++;
        }
        // 如果右区间中还有元素，那么把它都添加到 result 中
        while (start2 <= end2) {
            res[k] = nums[start2];
            k++;
            start2++;
        }
        for (k = start; k <= end; k++) {
            nums[k] = res[k];
        }
    }
}
