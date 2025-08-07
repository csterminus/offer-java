package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//前 K 个高频元素
public class Leetcode347 {

    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(map.get(nums[i]) != null){
                map.put(nums[i],map.get(nums[i]) + 1);
            }else{
                map.put(nums[i],1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue()
        );
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll().getKey();
        }

        return result;
    }
}
