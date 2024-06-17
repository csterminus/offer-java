package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengshi
 * @date 2024/6/17 11:47
 */
public class BacktrackTemplate {
    /**
     * void backtrack(路径, 选择列表):
     * if 满足结束条件:
     * 结果.append(路径) 存储结果
     * return
     * for 选择 in 选择列表:    # 核心代码段
     * if vst[i]:   # 辅助数组，减枝
     * continue
     * 做出选择
     * 递归执行backtrack
     * 撤销选择
     *
     * @param res
     * @param nums
     * @param temp
     * @param visited
     */
    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> temp, int[] visited) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            temp.add(nums[i]);
            backtrack(res, nums, temp, visited);
            visited[i] = 0;
            temp.remove(temp.size() - 1);
        }
    }
}
