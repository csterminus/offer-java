package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chengshi
 * @date 2024/5/14 10:52
 */
public class Leetcode452 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        Leetcode452 leetcode452 = new Leetcode452();
        System.out.println(leetcode452.findMinArrowShots(nums));
    }

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        // 按照区间的左端点从小到大排序
        Arrays.sort(points, (a, b) -> a[0] - b[0]);

        // 创建一个结果数组用于存储不重叠区间
        List<int[]> res = new ArrayList<>();
        // 当前区间初始值设置为第一个区间
        int[] cur = points[0];

        for (int i = 1; i < points.length; i++) {
            // 如果当前区间的右端点大于等于下一个区间的左端点，则更新当前区间的右端点
            if (cur[1] >= points[i][0]) {
                cur[0] = Math.max(cur[0], points[i][0]);
                cur[1] = Math.min(cur[1], points[i][1]);
            } else {
                // 否则把当前区间加入到结果数组中
                res.add(cur);
                // 并将当前区间更新为下一个区间
                cur = points[i];
            }
        }
        res.add(cur);
        return res.size();
    }
}
