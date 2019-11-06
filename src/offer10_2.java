import java.util.Arrays;

public class offer10_2 {
    //青蛙跳台阶 一次跳2阶或1阶
    public int JumpFloor(int n){
        if(n <= 2)
            return n;
        int pre2 = 1,pre1 = 2;
        int result = 1;
        for(int i = 2;i < n;i++){
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

    //变态跳台阶一次可以调1-n阶
    //等比数列
    public int JumpFloor2(int target){
        int[] dp = new int[target];
        Arrays.fill(dp,1);
        for(int i = 1; i < target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target -1];
    }

    //矩形覆盖

    public int RectCover(int n) {
        if (n <= 2)
            return n;

        int pre2 = 1, pre1 = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }
}
