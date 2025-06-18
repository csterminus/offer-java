package leetcode;

public class Leetcode226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = invertTree(root.right);
        newRoot.right = invertTree(root.left);
        return newRoot;
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
