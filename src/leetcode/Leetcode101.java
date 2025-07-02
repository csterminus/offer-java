package leetcode;
//是否为镜像二叉树
public class Leetcode101 {

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return false;
        }
        return isSymmetric2(root.left,root.right);
    }

    public boolean isSymmetric2(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        return root1.val == root2.val && isSymmetric2(root1.left,root2.right) && isSymmetric2(root1.right,root2.left);
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
