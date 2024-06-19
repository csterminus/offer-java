package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chengshi
 * @date 2024/6/17 10:57
 */
public class Leetcode39 {
    public static void main(String[] args) {
        Leetcode39 leetcode39 = new Leetcode39();
        int[] temp = new int[]{2, 3, 6, 7};
        List<List<Integer>> res = leetcode39.solution(temp, 7);
        System.out.println(res);
    }

    public List<List<Integer>> solution(int[] temp, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(temp);
        backtrack(res, 0, target, temp, list, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int sum, int target, int[] nums, List<Integer> temp, int start) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }
            temp.add(nums[i]);
            sum = sum + nums[i];
            backtrack(res, sum, target, nums, temp, i);
            sum = sum - nums[i];
            temp.remove(temp.size() - 1);
        }
    }
}
