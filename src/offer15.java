public class offer15 {
    /**
     * 题目：二进制中1的个数
     * 输入一个整数，输出该数二进制表示中 1 的个数。
     * 解题思路：位运算
     * 把n 和n-1 做与运算
     */

    public int NumberOf1(int n){
        int count = 0;
        while(n != 0){
             ++ count;
            n &= (n-1);
        }
        return count;
    }

}
