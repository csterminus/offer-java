package sort;

import java.util.Arrays;

public class InsertSort {
    /*
    时间复杂度 平均n*n
    插入排序的思想有点像打扑克抓牌的时候，我们插入扑克牌的做法。想象一下，
    抓牌时，我们都是把抓到的牌按顺序放在手中。因此每抓一张新牌，
    我们都将其插入到已有的排好序的手牌当中，注意体会刚才的那句话。
    也就是说，插入排序的思想是，将新来的元素按顺序放入一个已有的有序序列当中。

     */
    public static void sort(int[] arrays) {
        int temp;
        for (int i = 1; i < arrays.length; i++) {
            temp = arrays[i];
            int j = i - 1;
            while (j >= 0 && arrays[j] > temp) {
                arrays[j + 1] = arrays[j];
                j--;
            }
            arrays[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {87, 45, 78, 32, 17, 65, 53, 9, 122};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
