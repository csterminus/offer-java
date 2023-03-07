package leetcode;

public class Leetcode215 {
    //快排的思路找出k大个数
    public static void main(String[] args) {
        Leetcode215 leetcode215 = new Leetcode215();
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        System.out.println(leetcode215.quickSelect(nums,0,nums.length - 1,nums.length - k));
    }

    int partition(int[] nums,int i,int j){
        int target = nums[i];
        while(i < j){
            while(i < j && nums[j] >= target){
                j--;
            }
            nums[i] = nums[j];
            while(i < j && nums[i] <= target){
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = target;
        return i;
    }
    //根据快速排序的知识我们可以知道，每次partition算法会将所选的基准数（记为target）放到正确的位置，
    // 而我们其实只需要知道第k大的位置上的数是什么，而不需要关心其他位置是否有序。
    // 那么我们可以根据基准数的位置来判断，假如k在target的左边，那么我们只需要递归target左边即可，而不需要关心target右边是否有序；
    // 反之，如果k在target右边，我们只需要递归右边
    int quickSelect(int[] nums,int i,int j,int index){
        int k = partition(nums, i, j);
        if(k == index){
            return nums[k];
        }else if(k < index){
            return quickSelect(nums, k + 1, j, index);
        }else {
            return quickSelect(nums, i,k - 1, index);
        }
    }
}
