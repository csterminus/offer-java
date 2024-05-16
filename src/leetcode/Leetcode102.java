package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chengshi
 * @date 2024/5/15 17:05
 */
public class Leetcode102 {
    public static void main(String[] args) {
        Leetcode102 leetcode102 = new Leetcode102();
        leetcode102.test();
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        int count = 0;
        int cur = 1;
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            list.add(p.val);
            if (p.left != null) {
                queue.add(p.left);
                count++;
            }
            if (p.right != null) {
                queue.add(p.right);
                count++;
            }
            cur--;
            if (cur == 0) {
                res.add(list);
                list = new ArrayList<>();
                cur = count;
                count = 0;
            }
        }
        return res;
    }

    public void test() {
        Leetcode102.TreeNode t1 = new Leetcode102.TreeNode(1);
        Leetcode102.TreeNode t2 = new Leetcode102.TreeNode(2);
        Leetcode102.TreeNode t3 = new Leetcode102.TreeNode(3);
        Leetcode102.TreeNode t4 = new Leetcode102.TreeNode(4);
        Leetcode102.TreeNode t5 = new Leetcode102.TreeNode(5);
        Leetcode102.TreeNode t6 = new Leetcode102.TreeNode(6);
        Leetcode102.TreeNode t7 = new Leetcode102.TreeNode(7);
        Leetcode102.TreeNode t8 = new Leetcode102.TreeNode(8);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t4.left = t6;
        t4.right = t7;
        t5.left = t8;

        System.out.println(new Leetcode102().levelOrder(t1));
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
