package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class leetcode15 {
    public static void main(String[] args) {
        leetcode15 leetcode15 = new leetcode15();
        int[] nums = new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4};
        System.out.println(leetcode15.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3){
            return new ArrayList<>();
        }
        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length;i++){
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && (nums[i] == nums[i - 1])){
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r) {
                int res = nums[i] + nums[l] + nums[r];
                if(res == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    resList.add(list);
                    l++;
                    r--;
                    while(l < r && (nums[l] == nums[l - 1])){
                        l++;
                    }
                    while(l < r && (nums[r] == nums[r + 1])){
                        r--;
                    }
                } else if(res < 0){
                    l++;
                }else {
                    r--;
                }
            }
        }
        return resList;
    }

}
