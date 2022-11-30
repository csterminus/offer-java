package datastructure.Array;

public class Array<E> {
    private E[] data;
    private int size;
    //构造函数
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array(E[] arr){
        data = (E[])new Object[arr.length];
        for(int i = 0;i < arr.length;i ++)
            data[i] = arr[i];
        size = arr.length;
    }

    public Array(){
        this(10);
    }
    //获取数组的元素个数
    public int getSize(){
        return size;
    }
    //获取数组的容量
    public int getCapacity(){
    //返回数组是否为空
        return data.length;
}
    public boolean isEmpty(){
        return size == 0;
    }
    //向所有元素后添加一个新元素
    public void addLast(E e) throws IllegalAccessException {
       add(size,e);
    }
    public void addFirst(E e) throws IllegalAccessException {
        add(0,e);
    }
    //在第index个位置插入一个新元素e
    public void add(int index,E e) throws IllegalAccessException {
        if(index<0||index>size)
            throw new IllegalAccessException("AddLast failed");
        if(size == data.length)
            resize(2 * data.length);
        for(int i = size-1;i >=index;i--)
             data[i+1] = data[i];

        data[index] = e;
        size++;
    }
    // 获取index索引位置的元素
     public E get(int index) throws IllegalAccessException {
        if(index<0||index>=size)
            throw new IllegalAccessException("AddLast failed");
        return data[index];
    }
    // 修改index索引位置的元素为e
    public void set(int index,E e) throws IllegalAccessException {
        if(index<0||index>=size)
            throw new IllegalAccessException("AddLast failed");
        data[index] = e;
    }

    //查找数组中是否有元素e
    public boolean contains(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e))
            return true;
        }
        return false;
    }

    //查找数组中元素e所在的索引，如果不存元素e，则返回-1
    public int find(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    //从数组中删除index位置的元素，返回删除的元素
    public E remove(int index) throws IllegalAccessException {
        if(index<0||index>=size)
            throw new IllegalAccessException("AddLast failed");
        E ret = data[index];
        for(int i=index+1;i<size;i++)
            data[i-1] = data[i];
        size--;
        data[size] = null;
        if(size == data.length/4 &&data.length/2!=0)
            resize(data.length/2);
        return ret;
    }
    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst() throws IllegalAccessException {
        return remove(0);
    }
    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast() throws IllegalAccessException {
        return remove(size-1);
    }

    //从数组中删除元素e
    public void removeElement(E e) throws IllegalAccessException {
        int index = find(e);
        if(index!=-1)
            remove(index);
    }

    public void swap(int i, int j){
        if(i < 0 || i >= size || j < 0 || j >=size)
            throw new IllegalArgumentException();

        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array size=%d,capacity=%d\n",size,data.length));
        res.append('[');
        for(int i=0;i<size;i++){
            res.append(data[i]);
            if(i!=size-1)
                res.append(",");
        }
        res.append(']');
        return res.toString();
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i=0;i<size;i++)
            newData[i] = data[i];
        data = newData;
    }

    public E getLast() throws IllegalAccessException {
        return get(size-1);
    }

    public E getFirst() throws IllegalAccessException {
        return get(0);
    }

}