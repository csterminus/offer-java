package leetcode;

//验证是否为二叉搜索树
public class Leetcode98 {

    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return false;
        }
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return isValidBST(node.left, min, node.val)
                && isValidBST(node.right, node.val, max);
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
