package leetcode;

/**
 * @author chengshi
 * @date 2024/5/15 9:42
 */
public class Leetcode134 {
    //gas = [1,2,3,4,5], cost = [3,4,5,1,2]
    public static void main(String[] args) {
        Leetcode134 leetcode134 = new Leetcode134();
        leetcode134.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int countGas = 0;
        int countCost = 0;
        int temp = 0;
        for (int i = 0; i < gas.length; i++) {
            countGas = countGas + gas[i];
            countCost = countCost + cost[i];
        }
        if (countGas < countCost) {
            return -1;
        }
        int i = 0;
        int currentGas = 0;
        while (i < gas.length) {
            currentGas = currentGas + cost[i] - gas[i];
            if (currentGas < 0) {
                currentGas = 0;
                temp = i + 1;
                i++;
            } else {
                i++;
            }
        }

        return temp;
    }
}
