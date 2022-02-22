package offer;

public class offer3_2 {
    /*
    题目：不修改数组找出重复的数字

     */
    public int getDuplication(int[] nums,int length){
        if(nums == null || length<0)
            return -1;

        int start = 1;
        int end = length-1;
        while(end>=start) {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(nums, length, start, middle);
            if (end == start) {
                if (count > 1)
                    return start;
                else
                    break;
            }
            if (count > (middle - start + 1))
                end = middle;
            else start = middle + 1;
        }
        return -1;
        }

    private int countRange(int[] nums,int length ,int start,int end){
        if(nums == null)
            return 0;

        int count = 0;
        for(int i=0;i<length;i++)
            if(nums[i]>=start&&nums[i]<=end)
                ++count;
         return count;
    }
}
