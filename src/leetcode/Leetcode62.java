package leetcode;

/**
 * @author chengshi
 * @date 2024/6/12 14:40
 */
public class Leetcode62 {
    public static void main(String[] args) {
        Leetcode62 leetcode62 = new Leetcode62();
        leetcode62.uniquePaths(3,8);
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0;i < m;i++){
            dp[i][0] = 1;
        }
        for(int j = 0;j < n;j++){
            dp[0][j] = 1;
        }

        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                System.out.println(dp[i][j]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
