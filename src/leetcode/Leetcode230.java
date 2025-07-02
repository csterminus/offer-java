package leetcode;

public class Leetcode230 {
    //二叉搜索树中第 K 小的元素
    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k <= 0){
            return 0;
        }
        int t = getSize(root.left);
        if(t > k - 1){
            return kthSmallest(root.left,k);
        }else if(t < k - 1){
            return kthSmallest(root.right,k - t - 1);
        }else {
            return root.val;
        }
    }

    public int getSize(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        return getSize(treeNode.left) + getSize(treeNode.right) + 1;
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
