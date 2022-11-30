package datastructure.Array;

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayQueue(){
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
    public void enqueue(E e) throws IllegalAccessException {
        array.addLast(e);
    }

    @Override
    public E dequeue() throws IllegalAccessException {
        return array.removeFirst();
    }

    @Override
    public E getFront() throws IllegalAccessException {
        return array.getFirst();
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "array=" + array +
                '}';
    }

    public static void main(String[] args) throws IllegalAccessException {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for(int i=0;i<10;i++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i%3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
