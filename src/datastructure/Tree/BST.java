package datastructure.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//二分搜索树
public class BST<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }
    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //向二分搜索树种添加新的元素e
    public void add(E e){
       root = add(root,e);
    }

    //向node为根的二分搜索树中插入元素E，递归算法
    //返回插入新节点后二分搜索树的根
    private Node add(Node node,E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }
    public boolean contains(E e){
        return contains(root, e);
    }
    //查询
    private boolean contains(Node node,E e){
        if(node == null)
            return false;

        if(e.compareTo(node.e)==0)
            return true;
        else if(e.compareTo(node.e)<0)
            return contains(node.left,e);
        else
            return contains(node.right,e);

    }

    //前序遍历
    public void preOrder(){
        preOrder(root);

    }
    private void preOrder(Node node){
        if(node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);

    }

    //前序遍历 非递归
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if(cur.right!=null)
                stack.push(cur.right);
            if(cur.left!=null)
                stack.push(cur.left);
        }


    }
    //中序遍历
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){

        if(node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //后序遍历
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //层序遍历
    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);

            if(cur.left!=null)
                q.add(cur.left);
            if(cur.right!=null)
                q.add(cur.right);
        }
    }

    //寻找二分搜索树的最小元素
    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException();
        return mininum(root).e;
    }

    private Node mininum(Node node){
        if(node.left == null)
            return node;

        return mininum(node.left);
    }

    // 寻找二分搜索树的最大元素
    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        return maximum(root).e;
    }

    // 返回以node为根的二分搜索树的最大值所在的节点
    private Node maximum(Node node){
        if( node.right == null )
            return node;

        return maximum(node.right);
    }

    //从二分搜索树中删除最小值所在的结点
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;

    }

    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size -- ;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    //从二叉搜索树中删除最大值的节点
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e){
        root = remove(root,e);
    }


    private Node remove(Node node,E e){
        if(node == null)
            return null;
        if(e.compareTo(node.e)<0){
            node.left = remove(node.left,e);
            return node;
        }
        else if(e.compareTo(node.e)>0){
            node.right = remove(node.right,e);
            return node;
        }
        else {
            //待删除结点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //待删除结点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //待删除结点左右子树都不为空的情况
            //找到比待删除结点大的最小结点，即待删除结点右子树的最小及诶单
            //用这个结点顶替待删除结点的位置
            Node successor = mininum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();

    }

    //生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node,int depth,StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth)+"null\n");
            return;
        }
        res.append(generateDepthString(depth)+node.e+"\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i=0;i<depth;i++)
            res.append("--");
        return res.toString();

    }
}
