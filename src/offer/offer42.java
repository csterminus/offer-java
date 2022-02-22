package offer;

public class offer42 {
    //连续子数组最大和
    public boolean invalidInput = false;
    public int finGreatestSumOfArray(int[] array){
        if(array == null || array.length == 0){
            invalidInput = true;
            return 0;
        }
        //最大子数组和
        int maxSum = array[0];
        //累加子数组和
        int curSum = array[0];

        for(int i = 1;i < array.length; i++){
            if(curSum < 0){
                curSum = array[i];
            }else {
                curSum = curSum + array[i];
            }
            if(curSum > maxSum){
                maxSum = curSum;
            }
        }
        return curSum;
    }
}
