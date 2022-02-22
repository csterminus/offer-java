package offer;

public class offer11 {
    /**
     * 旋转数组中的最小数字
     */
    public int Min(int[] nums){
        int index1 = 0;
        int index2 = nums.length-1;
        int indexMid = index1;
        while(nums[index1] >= nums[index2]){
            if(index2 - index1 == 1){
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) / 2;

            //如果下标为index1、index2和indexMid指向的元素相等只能顺序查找
            if(nums[index1] == nums[index2] && nums[index1] == nums[indexMid])
                return MinInOrder(nums,index1,index2);
            if(nums[indexMid] >= nums[index1])
                index1 = indexMid;
            else if(nums[indexMid] <= nums[index2])
                index2 = indexMid;

        }
        return nums[indexMid];
    }

    private int MinInOrder(int[] nums,int index1,int index2){
        int result = nums[index1];
        for(int i = index1 + 1;i <= index2;++ i){
            if(result > nums[i])
                result = nums[i];
        }
        return result;
    }
}
