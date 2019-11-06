import java.util.*;

public class offer45 {
    //把数组排成最小的数
    /**
     * 题目描述
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * 例如输入数组 {3，32，321}，则打印出这三个数字能排成的最小数字为 321323。
     * 解题思路
     * 可以看成是一个排序问题，在比较两个字符串 S1 和 S2 的大小时，应该比较的是 S1+S2 和 S2+S1 的大小，
     * 如果 S1+S2 < S2+S1，那么应该把 S1 排在前面，否则应该把 S2 排在前面。
     */
    public String PrintMinNumber(int[] numbers){
        int n = numbers.length;
        String s = "";
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++)
            list.add(numbers[i]);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });
        for(int j : list){
            s += j;
        }
        return s;

    }
}
