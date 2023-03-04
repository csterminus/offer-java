package leetcode;

public class Leetcode123 {
    public static void main(String[] args) {
        Leetcode123 leetcode123 = new Leetcode123();
        int[] nums = new int[]{3,3,5,0,0,3,1,4};
        System.out.println(leetcode123.maxProfit(nums));
    }
    // dp[i][j]，表示的是i天，j状态所剩的最大现金
    //0.没有操作
    //1.第一次买入
    //2.第一次卖出
    //3.第二次买入
    //4.第二次卖出
    public int maxProfit (int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int len = prices.length;
        int[][] dp = new int[len][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        //没有操作沿用上一次的值
        for(int i = 1;i < len;i++){
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2],dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3],dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4],dp[i - 1][3] + prices[i]);
        }
        return dp[len - 1][4];

    }
}
