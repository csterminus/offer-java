package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengshi
 * @date 2024/5/28 9:31
 */
public class Leetcode120 {
    public static void main(String[] args) {
        Leetcode120 leetcode120 = new Leetcode120();
        //[[1,-1,-3]] 3 -1
        //[2,3],    1
        //[-1],
        List<List<Integer>> listList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        listList.add(list);
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        listList.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(-1);
        list2.add(-3);
        listList.add(list2);
        System.out.println(leetcode120.minimumTotal(listList));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
            dp[triangle.size() - 1][i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j] + triangle.get(i).get(j), dp[i + 1][j + 1] + triangle.get(i).get(j));
                System.out.println(dp[i][j]);
            }
        }
        return dp[0][0];
    }
}
