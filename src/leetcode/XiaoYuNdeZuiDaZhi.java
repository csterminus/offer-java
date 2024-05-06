package leetcode;

import java.util.*;

/**
 * @author chengshi
 * @date 2024/5/6 15:59
 */
public class XiaoYuNdeZuiDaZhi {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 9, 4};
        XiaoYuNdeZuiDaZhi xiaoYuNdeZuiDaZhi = new XiaoYuNdeZuiDaZhi();
        xiaoYuNdeZuiDaZhi.getMax(nums, 2533);
    }

    public int getMax(int[] nums, int n) {
        List<Integer> nDigits = new ArrayList<>();
        while (n > 0) {
            nDigits.add(n % 10);
            n = n / 10;
        }
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int[] tDigits = new int[nDigits.size()];
        for (int i = nDigits.size() - 1; i >= 0; i--) {
            if (i > 0 && set.contains(nDigits.get(i))) {
                tDigits[i] = nDigits.get(i);
                continue;
            }
            int d = getMaxDigit(nums, nDigits.get(i));
            if (d > 0) {
                tDigits[i] = d;
                break;
            }
            //回溯
            for (i++; i < nDigits.size(); i++) {
                tDigits[i] = 0;
                //小于当前位的最大数字
                d = getMaxDigit(nums, nDigits.get(i));
                if (d > 0) {
                    tDigits[i] = d;
                    break;
                }
                //最高位也没有小于其的最大数字
                if (i == nDigits.size() - 1) {
                    tDigits[tDigits.length - 1] = 0;
                }
            }
            break;
        }
        int target = 0;
        for (int i = tDigits.length - 1; i >= 0; i--) {
            target = target * 10;
            if (tDigits[i] > 0) {
                target = target + tDigits[i];
                continue;
            }
            target = target + nums[nums.length - 1];
        }
        System.out.println(target);
        return target;

    }

    public int getMaxDigit(int[] digits, int digit) {
        for (Integer inte : digits) {
            if (inte < digit) {
                return inte;
            }
        }
        return 0;
    }

}
