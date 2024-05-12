package leetcode;

/**
 * @author chengshi
 * @date 2024/5/8 17:53
 */
public class Leetcode88 {
    //合并两个有序数组
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        Leetcode88 leetcode88 = new Leetcode88();
        leetcode88.merge(nums1, 3, nums2, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[cur] = nums1[i];
                i--;
                cur--;
            } else {
                nums1[cur] = nums2[j];
                j--;
                cur--;
            }

        }
    }
}
