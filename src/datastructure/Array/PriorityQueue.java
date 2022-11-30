package datastructure.Array;

import com.Heap.MaxHeap;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue(){
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void enqueue(E e) throws IllegalAccessException {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() throws IllegalAccessException {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() throws IllegalAccessException {
        return maxHeap.findMax();
    }
}
