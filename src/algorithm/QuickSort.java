package algorithm;

import java.util.Arrays;
import java.util.Stack;

public class QuickSort {
    //递归
    /*
    时间复杂度n*log（n）
    通过一趟扫描将要排序的数据分割成独立的两部分,其中一部分的所有数据都比另外一部分的所有数据都要小,
    然后再按此方法对这两部分数据分别进行快速排序,整个排序过程可以递归进行,以此达到整个数据变成有序序列。
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivoIndex = partition(arr, low, high);
            quickSort(arr, low, pivoIndex - 1);
            quickSort(arr, pivoIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivotKey = arr[low];
        while (low < high) {
            while (low < high && pivotKey <= arr[high]) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && pivotKey > arr[low]) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivotKey;
        return low;
    }
    //非递归

    /**
     * 栈中存放着应该调用partition 的 low 和 high的指针
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSortNoRec(int[] arr, int left, int right) {
        Stack<Integer> stack = new Stack<>();
        stack.push(left);
        stack.push(right);
        while (!stack.isEmpty()) {
                int high = stack.pop();
                int low = stack.pop();
                int pivotIndex = partition(arr, low, high);
                if (low < pivotIndex ) {
                    stack.push(low);
                    stack.push(pivotIndex - 1);
                }
                if (pivotIndex  < high && pivotIndex>=0) {
                    stack.push(pivotIndex + 1);
                    stack.push(high);
                }
            }
        }

    public static void main(String[] args) {
        int[] arr = { 87, 45, 78, 32, 17, 65, 53, 9, 122 };
       // quickSort(arr,0,arr.length-1);
        quickSortNoRec(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
