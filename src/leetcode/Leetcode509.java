package leetcode;

/**
 * @author chengshi
 * @date 2024/5/22 14:09
 */
public class Leetcode509 {
    public static void main(String[] args) {
        Leetcode509 leetcode509 = new Leetcode509();
        leetcode509.fib(3);
    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] res = new int[n];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i < n; i++) {
            res[i] = res[i - 2] + res[i - 1];
        }
        return res[n - 1] + res[n - 2];
    }
}
