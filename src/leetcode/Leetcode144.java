package leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chengshi
 * @date 2024/5/15 10:04
 */
public class Leetcode144 {
    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                list.add(p.val);
                p = p.left;
            } else {
                p = stack.pop();
                p = p.right;
            }
        }
        return list;
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


