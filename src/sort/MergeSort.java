package sort;

import java.util.Arrays;

public class MergeSort {
    /*
    归并排序的效率是比较高的，设数列长为N，将数列分开成小数列一共要logN步，每步都是一个合并有序数列的过程，
    时间复杂度可以记为O(N)，故一共为O(N*logN)。因为归并排序每次都是在相邻的数据中进行操作，
    所以归并排序在O(N*logN)的几种排序方法（快速排序，归并排序，希尔排序，堆排序）也是效率比较高的。
     */
    public static void merge_sort(int[] array, int first, int last, int[] sorted) {
        if (first + 1 < last) {
            int mid = (first + last) / 2;
            System.out.println("{" + first + "}-{" + mid + "}-{" + last + "} ");
            System.out.println("-->>左大部分");
            merge_sort(array, first, mid, sorted);
            System.out.println("-->>右大部分");
            merge_sort(array, mid, last, sorted);
            System.out.println("开始了----->{" + first + "}-{" + mid + "}-{" + last + "} ");
            merge(array, first, mid, last, sorted);
            System.out.println("每次比较的结果：----->" + Arrays.toString(array));

        }

    }

    public static void merge(int[] array, int first, int mid, int last, int[] sorted) {
        int i = first, j = mid;
        int k = 0;
        while (i < mid && j < last) {
            if (array[i] < array[j]) {
                sorted[k++] = array[i++];
            } else {
                sorted[k++] = array[j++];
            }
        }

        while (i < mid) {
            sorted[k++] = array[i++];
        }
        while (j < last) {
            sorted[k++] = array[j++];
        }
        for (int v = 0; v < k; v++) {
            array[first + v] = sorted[v];
        }
    }

}
