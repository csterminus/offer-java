package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class offer32 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //二叉树的层次遍历
   public void fun(TreeNode root){
        if(root == null){
            return;
        }
        //定义队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            //取出头部节点
            TreeNode tempNode = queue.poll();
            System.out.println(tempNode.val + " ");
            if(tempNode.left != null){
                queue.add(tempNode.left);
            }
            if(tempNode.right != null){
                queue.add(tempNode.right);
            }
        }

   }

    //分行打印
    public void fun2(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //下一层节点的数量
        int nextLevel = 0;
        //当前层中还没有打印的节点数
        int toBePrinted = 1;

        while(!queue.isEmpty()){
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.val + " ");
            if(tempNode.left != null){
                queue.add(tempNode.left);
                nextLevel ++;
            }
            if(tempNode.right != null){
                queue.add(tempNode.right);
                nextLevel ++;
            }

            toBePrinted --;
            if(toBePrinted == 0){
                System.out.println();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }

    }

    //之字形打印
    public void fun3(TreeNode root){
        if(root == null)
            return;

        //子节点的加入为：从左到右
        Stack<TreeNode> s1 = new Stack<>(); //存储奇数层节点
        //子节点的加入为：从右到左
        Stack<TreeNode> s2 = new Stack<>();//存储偶数层节点
        s1.add(root);
        while(!s1.empty() || !s2.isEmpty()){
            if(s1.isEmpty() && s2.isEmpty()){
                break;//如果两个栈都为空就退出循环
            }

            if(!s1.isEmpty()){
                while(!s1.isEmpty()){
                    TreeNode node = s1.pop();
                    System.out.print(node.val + " ");
                    if(node.left != null){
                        s2.add(node.left);
                    }
                    if(node.right != null){
                        s2.add(node.right);
                    }
                }
                System.out.println();
            }else {
                while(!s2.isEmpty()){
                    TreeNode node = s2.pop();
                    System.out.print(node.val + " ");
                    if(node.right != null ){
                        s1.add(node.right);
                    }
                    if(node.left != null){
                        s1.add(node.left);
                    }
                }
                System.out.println();
            }
        }
    }

}
