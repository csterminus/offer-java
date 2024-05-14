package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengshi
 * @date 2024/5/12 16:18
 */
public class Leetcode315 {
    /**
     * 将数组分为两个区间，先统计左边的逆序数对 A，在统计右边的逆序数对B，最后在左边取一个数，在右边取一个数 组成逆序数c
     */
    int[] counts;
    int[] index;
    int[] helpNums;
    int[] helpIndex;

    public static void main(String[] args) {

    }

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        counts = new int[nums.length];
        index = new int[nums.length];
        helpNums = new int[nums.length];
        helpIndex = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        mergeSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            list.add(counts[i]);
        }
        return list;

    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        int cur1 = left, cur2 = mid + 1, i = 0;
        while (cur1 <= mid && cur2 <= right) {
            if (nums[cur1] > nums[cur2]) {
                counts[index[cur1]] = counts[index[cur1]] + right - cur2 + 1;
                helpNums[i] = nums[cur1];
                helpIndex[i++] = index[cur1++];
            } else {
                helpNums[i] = nums[cur2];
                helpIndex[i++] = index[cur2++];
            }
        }
        while (cur1 <= mid) {
            helpNums[i] = nums[cur1];
            helpIndex[i++] = index[cur1++];
        }

        while (cur2 <= right) {
            helpNums[i] = nums[cur2];
            helpIndex[i++] = index[cur2++];
        }
        for (int j = left; j <= right; j++) {
            nums[j] = helpNums[j - left];
            index[j] = helpIndex[j - left];
        }
    }
}
