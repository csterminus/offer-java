package leetcode;

public class Leetcode122 {
    public static void main(String[] args) {
        Leetcode122 leetcode122 = new Leetcode122();
        int[] price = new int[]{8,9,2,5,4,7,1};
        System.out.println(leetcode122.maxProfit(price));
    }

    public int maxProfit (int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int sum = 0;
        for(int i = 1;i < prices.length;i++){
            if(prices[i] > prices[i - 1]){
                sum = sum + prices[i] - prices[i - 1];
            }
        }
        return sum;
    }
}
