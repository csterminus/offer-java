package leetcode;

/**
 * @author chengshi
 * @date 2024/5/14 10:31
 */
public class Leetcode860 {
    public static void main(String[] args) {

    }

    public boolean lemonadeChange(int[] bills) {
        boolean res = true;
        int count5 = 0;
        int count10 = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                count5++;
            } else if (bills[i] == 10) {
                if (count5 <= 0) {
                    res = false;
                    break;
                } else {
                    count5--;
                    count10++;
                }
            } else {
                if ((count5 >= 1 && count10 >= 1)) {
                    count5--;
                    count10--;
                } else if (count5 >= 3) {
                    count5 = count5 - 3;
                } else {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }
}
