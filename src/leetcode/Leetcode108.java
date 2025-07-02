package leetcode;

//数组转化二叉搜索树
public class Leetcode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return dfsBST(nums,0,nums.length - 1);
    }
    //该函数dfsBST是一个递归方法，用于将一个有序数组转换成一棵高度平衡的二叉搜索树（BST）。在这个项目中
    private TreeNode dfsBST(int[] nums, int left, int right) {
        if(left > right){
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfsBST(nums,left,mid - 1);
        root.right = dfsBST(nums, mid + 1, right);
        return root;
    }
    public static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        private TreeNode(int val){
            this.val = val;
        }
    }
}
