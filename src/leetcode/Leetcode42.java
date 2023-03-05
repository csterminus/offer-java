package leetcode;

public class Leetcode42 {
    //容器接雨水
    public static void main(String[] args) {
        Leetcode42 leetcode42 = new Leetcode42();
        int[] nums = new int[]{3,1,2,5,2,4};
        System.out.println(leetcode42.maxWater(nums));
    }

    public long maxWater (int[] arr) {
        int left = 0,right = arr.length - 1;
        int ans = 0,lmax = 0,rmax = 0;
        while(left < right){
            lmax = Math.max(lmax,arr[left]);
            rmax = Math.max(rmax,arr[right]);
            if(lmax < rmax){
                ans = ans + lmax - arr[left];
                left++;
            }else {
                ans = ans + rmax - arr[right];
                right--;
            }
        }
        return ans;
    }
}