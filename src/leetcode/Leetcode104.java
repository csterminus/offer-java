package leetcode;

/**
 * @author chengshi
 * @date 2024/6/28 17:05
 */
public class Leetcode104 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t4.left = t6;
        t4.right = t7;
        t5.left = t8;
        Leetcode104 leetcode104 = new Leetcode104();
        System.out.println(leetcode104.maxDepth(t1));
    }

    public int maxDepth(TreeNode root) {
        // 如果 root 为空，直接返回 0
        if (root == null) {
            return 0;
        }

        // 递归调用 maxDepth，求出当前节点的左子树的最大深度
        int left = maxDepth(root.left);

        // 递归调用 maxDepth，求出当前节点的右子树的最大深度
        int right = maxDepth(root.right);

        // 求出当前节点的左右子树中较大的值
        int childMaxDepth = Math.max(left, right);

        // 二叉树的最大深度就是它的左右子树中较大的值加上 1
        return childMaxDepth + 1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
}
