package datastructure.LinkerList;

import com.Array.Stack;

public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> list;

    public LinkedListStack(){
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) throws IllegalAccessException {
        list.addFirst(e);
    }

    @Override
    public E pop() throws IllegalAccessException {
        return list.removeFirst();
    }

    @Override
    public E peek() throws IllegalAccessException {
        return list.getFirst();
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("com.Array.Stack: top ");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) throws IllegalAccessException {

        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }


}
