package leetcode;

public class leetcode4 {
    //两个数组的中位数
    public static void main(String[] args) {
        leetcode4 leetcode4 = new leetcode4();
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        System.out.println(leetcode4.findMedianSortedArrays(nums1,nums2));
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
        stringThreadLocal.set("test");
        stringThreadLocal.get();
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int total = 0;
        int start1 = 0;
        int start2 = 0;
        while(start1 < nums1.length || start2 < nums2.length){
            if(start1 < nums1.length && start2 < nums2.length){
                if(nums1[start1] <= nums2[start2]){
                    res[total] = nums1[start1];
                    start1++;
                }else {
                    res[total] = nums2[start2];
                    start2++;
                }
                total++;
            }else if(start1 == nums1.length){
                res[total] = nums2[start2];
                total++;
                start2++;
            }else if(start2 == nums2.length){
                res[total] = nums1[start1];
                total++;
                start1++;
            }
        }
        double temp = 0;
        if(res.length % 2 ==0){
            temp = (double) (res[res.length / 2] + res[res.length / 2 - 1]) / 2;
        }else {
            temp = res[(res.length - 1) / 2];
        }
        return temp;
    }
}
