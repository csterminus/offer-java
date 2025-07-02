package leetcode;

import java.util.HashMap;
import java.util.Map;

//和为k的子数组
public class Leetcode560 {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);

        for (int num : nums) {
            prefixSum += num;
            if (prefixSumMap.containsKey(prefixSum - k)) {
                count += prefixSumMap.get(prefixSum - k);
            }
            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
