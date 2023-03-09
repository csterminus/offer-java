package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode56 {
    //合并区间
    public static void main(String[] args) {
        Leetcode56 leetcode56 = new Leetcode56();
        int[][] nums = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println(leetcode56.merge(nums));
    }

    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return new int[0][0];
        }
        // 按照区间的左端点从小到大排序
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        // 创建一个结果数组用于存储不重叠区间
        List<int[]> res = new ArrayList<>();
        // 当前区间初始值设置为第一个区间
        int[] cur = intervals[0];

        for(int i = 1;i < intervals.length;i++){
            // 如果当前区间的右端点大于等于下一个区间的左端点，则更新当前区间的右端点
            if(cur[1] >= intervals[i][0]){
                cur[1] = Math.max(cur[1],intervals[i][1]);
            }else {
                // 否则把当前区间加入到结果数组中
                res.add(cur);
                // 并将当前区间更新为下一个区间
                cur = intervals[i];
            }
        }
        res.add(cur);
        return res.toArray(new int[res.size()][2]);
    }
}
