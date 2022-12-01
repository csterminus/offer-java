package datastructure.Heap;


import datastructure.Array.Array;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;
    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    public MaxHeap(E[] arr) throws IllegalAccessException {
        data = new Array<>(arr);
        for(int i= parent(arr.length - 1); i >= 0 ;i--)
            siftDown(i);
    }

    //返回堆中元素个数
    public int size(){
        return data.getSize();
    }

    //返回一个布尔值，表示堆中是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index){
        if(index == 0)
            throw new IllegalArgumentException();
        return (index - 1) / 2;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftchild(int index){
        return index * 2 + 1;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightchild(int index){
        return index * 2 + 2;
    }

    //向堆中添加元素
    public void add(E e) throws IllegalAccessException {
        data.addLast(e);
        siftUp(data.getSize()-1);
    }

    private void siftUp(int k) throws IllegalAccessException {
        while(k > 0 && data.get(parent(k)).compareTo(data.get(k))<0){
            data.swap(k,parent(k));
            k = parent(k);
        }
    }

    //看堆中最大元素
    public E findMax() throws IllegalAccessException {
        if(data.getSize() == 0)
            throw new IllegalArgumentException();
        return data.get(0);
    }

    //取出最大元素
    public  E extractMax() throws IllegalAccessException {
        E ret = findMax();
        data.swap(0,data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) throws IllegalAccessException{
        while (leftchild(k) < data.getSize()){
            int j = leftchild(k);
            if(j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0)
                j = rightchild(k);
            //data[j] 是leftChild 和 rightChild 中的最大值

            if(data.get(k).compareTo(data.get(j)) >= 0)
                break;
            data.swap(k,j);
            k = j;
        }
    }

    //取出堆中最大元素，并且替换成元素E
    public E replace(E e) throws IllegalAccessException {
        E ret = findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }

    //
}
