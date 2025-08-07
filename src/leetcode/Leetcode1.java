package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1 {
    public static void main(String[] args) {
        Leetcode1 leetcode1 = new Leetcode1();
        leetcode1.twoSum(new int[]{3,2,4},6);
    }
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            map.put(nums[i],i);
        }
        int[] res = new int[2];
        for(int i = 0;i < nums.length;i++){
            if(map.get(target - nums[i]) != null && (i != map.get(target - nums[i]))){
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                break;
            }
        }
        return res;

    }
}
