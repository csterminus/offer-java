package offer;

import java.util.HashMap;
import java.util.Map;

public class offer7 {
    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);

    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }

    public TreeNode build(int[] preorder, int[] inorder, int left, int right, int inL) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[left]);
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        int leftSize = index - inL;
        root.left = build(preorder, inorder, left + 1, left + leftSize, inL);
        root.right = build(preorder, inorder, left + leftSize + 1, right, inL + leftSize + 1);
        return root;
    }

    /**
     * 重建二叉树
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
