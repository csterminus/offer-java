package leetcode;

/**
 * @author chengshi
 * @date 2024/5/24 9:43
 */
public class Leetcode72 {
    public static void main(String[] args) {

    }

    /**
     * dp[i][j] = min(dp[i-1][j] + 1,    // 删除
     *                dp[i][j-1] + 1,    // 插入
     *                dp[i-1][j-1] + 1)  // 替换
     *                初始化
     * dp[0][j] 表示将空字符串转换成 word2 的前 j 个字符，需要 j 次插入操作，即 dp[0][j] = j。
     * dp[i][0] 表示将 word1 的前 i 个字符转换成空字符串，需要 i 次删除操作，即 dp[i][0] = i。
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0;i <= m;i++){
            dp[i][0] = i;
        }
        for(int j = 0;j <= n;j++){
            dp[0][j] = j;
        }
        for(int i = 1;i <= m;i++){
            for(int j = 1;j <= n;j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    int temp = Math.min(dp[i - 1][j] + 1,dp[i][j - 1] + 1);
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1,temp);
                }
            }
        }
        return dp[m][n];
    }
}
