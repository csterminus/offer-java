package leetcode;

/**
 * @author chengshi
 * @date 2024/5/12 15:54
 */
public class Leetcode75 {
    /**
     * 颜色分类
     * 设置 3 个索引，left 指向数组的开始位置，right 指向数组的结束位置，index 指向数组的开始位置。
     * <p>
     * 我们让 index 从头开始向后移动，在移动的过程中，它指向的元素会出现三种情况：
     * <p>
     * 如果 index位置上的元素值为 0，则说明是红色，要放在最前面去，此时最前面的那个元素被 left 指着，所以让 index 指向的元素和 left 指向位置上的元素进行交换，交换完毕之后，说明 0 已经在它应该在的位置，即在整个数组的左区域，所以 left 可以向后移动，index 也向后移动
     * 如果若 index 位置上的元素值为 1，则说明是白色，就应该放在中间，不用管它，继续移动 index
     * <p>
     * 如果 index 位置上的元素值为 2，则说明是蓝色，要放在最后面，此时最后面的那个元素被 right 指着，所以让 index 指向的元素和 right 指向位置上的元素进行交换，交换完毕之后，说明 2 已经在它改在的位置，即在整个数组的右区域，right 向前移动，但由于原先 right 指向的元素可能为 0、1、2 这三种的任何一种，到了 index 后，还需要继续观察一轮，所以 index 先不移动
     */

    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {
        int index = 0;
        int left = 0;
        int right = nums.length - 1;
        while (index <= right) {
            if (nums[index] == 0) {
                int temp = nums[left];
                nums[left] = nums[index];
                nums[index] = temp;
                index++;
                left++;
            } else if (nums[index] == 1) {
                index++;
            } else if (nums[index] == 2) {
                int temp = nums[right];
                nums[right] = nums[index];
                nums[index] = temp;
                right--;
            }
        }
    }

}
