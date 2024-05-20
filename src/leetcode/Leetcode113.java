package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengshi
 * @date 2024/5/16 14:27
 */
public class Leetcode113 {
    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        back(root, targetSum, new ArrayList<>());
        return res;
    }

    private void back(TreeNode node, int target, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        target = target - node.val;
        if (target == 0 && node.left == null && node.right == null) {
            res.add(new ArrayList<>(list));
        }
        back(node.left, target, list);
        back(node.right, target, list);
        list.remove(list.size() - 1);
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
