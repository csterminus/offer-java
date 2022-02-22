package offer;

public class offer21 {
    //调整数组顺序使奇数位于偶数前面
    public void ReorderOddEvent(int length,int[] arr){
        int begin = 0;
        int end = length - 1;
        while(begin < end){
            //向后移动begin直到它指向偶数
            while (begin < end && (arr[begin] & 0x1)!=0)
                begin ++;
            //向前移动end直到它指向奇数
            while(begin < end && (arr[end] & 0x1) == 0)
                end --;
            if(begin < end)
            {
                int temp = arr[begin];
                arr[begin] = arr[end];
                arr[end] = temp;
            }

        }
    }
}
