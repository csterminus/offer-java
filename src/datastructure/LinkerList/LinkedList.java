package datastructure.LinkerList;

public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;
        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
    private Node dummyhead;
    private int size;

    public LinkedList(){
        dummyhead = new Node(null,null);
        size = 0;
    }

    //获取链表中的元素个数
    public int getSize(){
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //在链表头添加新的元素e

    public void add(int index,E e){
        if(index<0||index>size)
            throw new IllegalArgumentException("add failed Illegal index");
        else {
            Node prev = dummyhead;
            for(int i=0;i<index;i++)
                prev = prev.next;
            prev.next = new Node(e,prev.next);
            size++;
        }
    }
    public void addFirst(E e){
       add(0,e);
    }

    public void addLast(E e){
        add(size,e);
    }

    public E get(int index){
        if(index<0||index>size)
            throw new IllegalArgumentException("add failed Illegal index");
        else {
            Node cur = dummyhead.next;
            for(int i=0;i<index;i++)
                cur = cur.next;
            return cur.e;
        }
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    //更新
    public void set(int index,E e){
        if(index<0||index>size)
            throw new IllegalArgumentException("add failed Illegal index");
        Node cur = dummyhead.next;
        for(int i=0;i<index;i++)
            cur = cur.next;
        cur.e = e;
    }

    //查找
    public boolean contains(E e){
        Node cur = dummyhead.next;
        while(cur!=null){
            if(cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    //删除
    public E remove(int index){
        if(index<0||index>size)
            throw new IllegalArgumentException("add failed Illegal index");
        Node prev = dummyhead;
        for(int i=0;i<index;i++){
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    public void removeElement(E e){

        Node prev = dummyhead;
        while(prev.next != null){
            if(prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

//        Node cur = dummyHead.next;
//        while(cur != null){
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for(Node cur = dummyhead.next ; cur != null ; cur = cur.next)
            res.append(cur + "->");
        res.append("NULL");

        return res.toString();
    }


}
