package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chengshi
 * @date 2024/7/17 11:04
 */
public class Leetcode128 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 230, 6, 8, 7, 0, 9, 100};
        Leetcode128 leetcode128 = new Leetcode128();
        System.out.println(leetcode128.longestSize(nums));
    }

    private int longestSize(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int res = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int large = 1;
                while (set.contains(num + 1)) {
                    num++;
                    large++;
                }
                res = Math.max(res, large);
            }
        }
        return res;
    }
}
