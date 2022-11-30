package datastructure.Array;

public class ArrayStack<E> implements Stack<E> {
    Array<E> array;
    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayStack(){
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void push(E e) throws IllegalAccessException {
        array.addLast(e);
    }

    @Override
    public E pop() throws IllegalAccessException {
        return array.removeLast();
    }

    @Override
    public E peek() throws IllegalAccessException {
        return array.getLast();
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "array=" + array +
                '}';
    }
}
