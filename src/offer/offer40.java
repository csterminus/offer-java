package offer;

public class offer40 {
    //第二种解法 大顶堆维护 适合处理海量数据
    //O（log k)
    //初始化大顶堆
    public void initMaxHeap(int[] data, int lastIndex) {
        //(lastIndex - 1) / 2 表示最后一个非叶子节点
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            int k = i;
            while (k * 2 + 1 <= lastIndex) {
                int biggerIndex = k * 2 + 1;
                if (biggerIndex < lastIndex) {
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        biggerIndex = biggerIndex + 1;
                    }
                }
                if (data[biggerIndex] > data[k]) {
                    swap(data, k, biggerIndex);
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    //调整堆
    public void adjustHeap(int[] data, int lastIndex) {
        int k = 0;
        while (k * 2 + 1 <= lastIndex) {
            int biggerIndex = k * 2 + 1;
            if (biggerIndex < lastIndex) {
                if (data[biggerIndex] < data[biggerIndex + 1])
                    biggerIndex = biggerIndex + 1;
            }
            if (data[k] < data[biggerIndex]) {
                swap(data, k, biggerIndex);
                k = biggerIndex;
            } else {
                break;
            }
        }
    }

    //交换数组中的两个元素
    public void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    //最小的k个数
    //O(n)解法，比第k个小的都放在数组的左边，大的放右边 可以修改数组时可用
    //1、index 小于 k，说明从 0 到 index 这个左侧区间中的元素不足 k 个，那么最小的 k 个数肯定部分是在这个区间，还需要继续在右侧区间中去寻找出一部分元素来填充，因此对对右侧区间进行快速排序即可
    //2、index 等于 k，说明从 0 到 index 这个区间中的所有元素就是那些最小的 k 个数，将其返回。
    //3、index 大于 k，说明从 0 到 index 这个左侧区间中的元素超过了 k 个，那么最小的 k 个数肯定是都在在这个区间，而中间、右侧区间均可以不去处理，只需要继续对左侧区间进行快速排序即可，找到那 k 个数。
    //快速选择
    public class LeastNumbersInArray {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (arr == null || arr.length == 0) {
                return null;
            }
            int[] result = new int[k];
            int low = 0;
            int high = arr.length - 1;
            int index = partition(arr, low, high);
            while (index != k - 1) {
                if (index > k - 1) {
                    high = index - 1;
                    index = partition(arr, low, high);
                } else {
                    low = index + 1;
                    index = partition(arr, low, high);
                }
            }
            for (int i = 0; i < k; i++) {
                result[i] = arr[i];
            }
            return result;
        }

        public int partition(int[] arr, int low, int high) {
            //基准数
            int base = arr[low];
            while (low < high) {
                while (arr[high] >= base && low < high) {
                    high--;
                }
                arr[low] = arr[high];
                while (arr[low] <= base && low < high) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = base;
            return low;
        }
    }


}
