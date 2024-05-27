package leetcode;

/**
 * @author chengshi
 * @date 2024/5/24 9:43
 */
public class Leetcode72 {
    public static void main(String[] args) {

    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[j][0] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int temp = Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1);
                    dp[i][j] = Math.min(temp, dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
