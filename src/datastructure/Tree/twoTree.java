package datastructure.Tree;

import java.util.Stack;

public class twoTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    //递归前序
    public void preOrder(TreeNode node){
        if(node == null)
            return;
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }
    //非递归前序
//    如果当前节点p不为空，访问结点p，并将结点p入栈，并继续访问左子树(直到左子树为空)；
//    否则将栈顶元素出栈，并访问栈顶的元素的右子树；
//    直到栈为空且p为空，循环结束。
    public void iterativePre(TreeNode node){
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = node;
        while(!s.isEmpty() || p != null){
            if(p != null){
                s.push(p);
                System.out.println(p.val);
                p = p.left;
            }else{
                p = s.pop();
                p = p.right;
            }
        }
    }
    //递归中序遍历
    public void inOrder(TreeNode node){
        if(node == null)
            return;
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }
    //非递归中序遍历
//    当前节点不空!= null，压入栈中(和前序遍历不同的是，不需要打印)，当前节点向左；
//    当前节点为空== null，从栈中拿出一个并且打印(在这里打印) ，当前节点向右；
    public void iterativeIn(TreeNode node){
        if(node == null)
            return;
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = node;
        while(!s.isEmpty() || p != null){
            if(p != null){
                s.push(p);
                p = p.left;
            }else{
                p = s.pop();
                System.out.println(p.val);
                p = p.right;
            }
        }
    }
    //递归后序
    public void postOrder(TreeNode node){
        if(node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);
    }
    //非递归后序
    //后序遍历的非递归实现是三种遍历方式中最难的一种。因为在后序遍历中，要保证左孩子和右孩子都已被访问并且左孩子在右孩子前访问
    // 才能访问根结点，这就为流程的控制带来了难题。下面介绍思路。
    //要保证根结点在左孩子和右孩子访问之后才能访问，因此对于任一结点P，先将其入栈。如果P不存在左孩子和右孩子，
    // 则可以直接访问它；或者P存在左孩子或者右孩子，但是其左孩子和右孩子都已被访问过了，则同样可以直接访问该结点。
    // 若非上述两种情况，则将P的右孩子和左孩子依次入栈，这样就保证了每次取栈顶元素的时候，左孩子在右孩子前面被访问，
    // 左孩子和右孩子都在根结点前面被访问。
    public void iterPost(TreeNode node){
        Stack<TreeNode> s = new Stack<>();
        if(node == null)
            return;
        TreeNode cur,pre = null;
        s.push(node);
        while(!s.isEmpty()){
            cur = s.peek();
            if((cur.left == null && cur.right == null) || (pre != null && (cur.left == pre || cur.right == pre))){
                TreeNode temp = s.peek();
                System.out.println(temp.val);
                pre = temp;
            }else{
                if(cur.right != null)
                    s.push(cur.right);
                if(cur.left != null)
                    s.push(cur.left);
            }
        }
    }
    //查询树中有没有目标结点
    public TreeNode search(TreeNode node,int x){
        if(node == null)
            return null;
        if(node.val == x)
            return node;
        else{
            if(search(node.left,x) == null)
                return search(node.right,x);
            else
                return search(node.left,x);
        }
    }
    //计算树的高度
    public int depth(TreeNode node){
        if(node == null)
            return 0;
        return Math.max(depth(node.left),depth(node.right)) + 1;
    }
    
    //两个节点间的最短路径
    public int shortPath(TreeNode root,TreeNode p,TreeNode q){
        TreeNode ans = lowestAns(root,p,q);

        int one = getPath(ans,p) - 1;
        int two = getPath(ans,q) - 1;

        return one + two;
    }

    //求距离
    private int getPath(TreeNode root,TreeNode target){
        if(root == null){
            return 0;
        }

        int left = getPath(root.left,target);
        int right = getPath(root.right,target);

        if(root == target){
            return 1;
        }

        if(left == 0 && right == 0){
            return 0;
        }
        return left == 0 ? right + 1 : left + 1;
    }
    //求公共祖先
    private TreeNode lowestAns(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestAns(root.left,p,q);
        TreeNode right = lowestAns(root.right,p,q);

        if(left == null && right == null){
            return null;
        }
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }

    public static void main(String[] args) {
        twoTree twoTree = new twoTree();
        twoTree.test();
    }
    public void test() {
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

        System.out.println(new twoTree().shortPath(t1, t7, t3));
    }

}
