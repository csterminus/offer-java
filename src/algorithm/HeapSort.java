package algorithm;

import java.util.Arrays;

public class HeapSort {
    /**
     * 、基本思想
     * 此处以大顶堆为例，堆排序的过程就是将待排序的序列构造成一个堆，选出堆中最大的移走，再把剩余的元素调整成堆，找出最大的再移走，重复直至有序。
     * 2、算法描述
     * ①. 先将初始序列K[1..n]建成一个大顶堆, 那么此时第一个元素K1最大, 此堆为初始的无序区.
     * ②. 再将关键字最大的记录K1 (即堆顶, 第一个元素)和无序区的最后一个记录 Kn 交换, 由此得到新的无序区K[1..n−1]和有序区K[n], 且满足K[1..n−1].keys⩽K[n].key
     * ③. 交换K1 和 Kn 后, 堆顶可能违反堆性质, 因此需将K[1..n−1]调整为堆. 然后重复步骤②, 直到无序区只有一个元素时停止.
     * 父节点i的左子节点在位置：（2*i+1)
     * 父节点i的右子节点在位置：（2*i+2）
     * 子节点i的父节点在floor((i-1)/2)
     */
    public static void heapSort(int[] arr){
        for(int i = arr.length-1; i > 0; i--){
            max_heapify(arr,i);

            int temp = arr[0];//堆顶元素(第一个元素)与Kn交换
            arr[0] = arr[i - 1];
            arr[i - 1] = temp;
        }
    }

    private static void max_heapify(int[] arr, int limit) {
        if(arr.length <= 0 || arr.length <limit)
            return;
        int parentIdx = limit / 2;

        for(; parentIdx>=0; parentIdx--){
            if(parentIdx * 2 >= limit){
                continue;
            }
            int left = parentIdx * 2; //左子节点位置
            int right = (left + 1) >= limit ? left : (left + 1);//右子节点位置，如果没有右节点，默认为左节点位置

            int maxChildId = arr[left] >= arr[right] ? left : right;
            if(arr[maxChildId] > arr[parentIdx]){  //交换父节点与左右子节点中的最大值
                int temp = arr[parentIdx];
                arr[parentIdx] = arr[maxChildId];
                arr[maxChildId] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = { 87, 45, 78, 32, 17, 65, 53, 9, 122 };
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arr);
    }

}
