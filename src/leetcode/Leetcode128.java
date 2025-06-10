package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chengshi
 * @date 2024/7/17 11:04
 * 最长连续序列
 */
public class Leetcode128 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 230, 6, 8, 7, 0, 9, 100};
        Leetcode128 leetcode128 = new Leetcode128();
        System.out.println(leetcode128.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < nums.length;i++){
            set.add(nums[i]);
        }

        int max = 1;
        for(Integer num : set){
            if(!set.contains(num - 1)){
                int currentNum = num;
                int temp = 1;
                while(set.contains(currentNum + 1)){
                    temp++;
                    currentNum++;
                }
                max = Math.max(max,temp);
            }
        }
        return max;
    }
}
