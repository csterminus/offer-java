package leetcode;

public class Leetcode121 {
    //买股票的最好时机1
    public static void main(String[] args) {
        Leetcode121 leetcode121 = new Leetcode121();
        int[] nums = new int[]{8,9,2,5,4,7,1};
        System.out.println(leetcode121.maxProfit(nums));
    }

    public int maxProfit (int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        // 因为 今天的最大利润 = 今天的价格 - 以前的最低价格
        // 且 昨天的最大利润 = 昨天天的价格 - 以前的最低价格
        // 所以今天的最大利润 = 今天的价格 - 昨天的价格 + 昨天的最大利润
        int[] dp_max = new int[prices.length];
        int res = 0;
        dp_max[0] = 0;
        for(int i = 1;i < prices.length;i++){
            dp_max[i] = dp_max[i - 1] + prices[i] - prices[i - 1] > 0 ? dp_max[i - 1] + prices[i] - prices[i - 1] : 0;
            res = Math.max(res,dp_max[i]);
        }
        return res;

    }
}
