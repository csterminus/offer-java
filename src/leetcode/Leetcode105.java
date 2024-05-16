package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chengshi
 * @date 2024/5/15 17:43
 */
public class Leetcode105 {
    Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return reBuildTwoTree(preorder, 0, preorder.length - 1, 0);
    }

    public TreeNode reBuildTwoTree(int[] preorder, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preL]);
        int index = map.get(preorder[preL]);
        int leftSize = index - inL;
        root.left = reBuildTwoTree(preorder, preL + 1, preL + leftSize, inL);
        root.right = reBuildTwoTree(preorder, preL + leftSize + 1, preR, inL + leftSize + 1);
        return root;
    }

    public class TreeNode {
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
