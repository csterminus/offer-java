package sort;

public class BinarySearch {
    public static int rank(int key, int[] a) {
        //数组必须是有序的
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key < a[mid]) {
                high = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    //时间复杂度O(log n)

    public static void main(String[] args) {

    }
}
