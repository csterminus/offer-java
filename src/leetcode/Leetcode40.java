package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chengshi
 * @date 2024/6/12 14:39
 */
public class Leetcode40 {
    public static void main(String[] args) {
        Leetcode40 leetcode40 = new Leetcode40();
        int[] temp = new int[]{10,1,2,7,6,1,5};
        Arrays.sort(temp);
        List<List<Integer>> res = leetcode40.combinationSum2(temp,8);
        res = res.stream().distinct().collect(Collectors.toList());
        System.out.println(res);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        back(list,res,target,0,candidates,0);
        return res;
    }


    public void back(List<Integer> list,List<List<Integer>> res,int target,int sum,int[] candidates,int index) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            sum = sum + candidates[i];

            back(list, res, target, sum, candidates, i + 1);
            sum = sum - candidates[i];
            list.remove(list.size() - 1);

        }
    }
}
