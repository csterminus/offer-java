package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode46 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Leetcode46 leetcode46 = new Leetcode46();
        leetcode46.permute(nums);
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrack(res,nums,new ArrayList<Integer>(),visited);
        return res;
    }

    private void backtrack(List<List<Integer>> res,int[] nums,ArrayList<Integer> temp,int[] visited){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(visited[i] == 1){
                continue;
            }
            visited[i] = 1;
            temp.add(nums[i]);
            backtrack(res,nums,temp,visited);
            visited[i] = 0;
            temp.remove(temp.size() - 1);
        }
    }
}
