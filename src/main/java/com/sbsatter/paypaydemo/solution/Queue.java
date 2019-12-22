package com.sbsatter.paypaydemo.solution;

public interface Queue<E> {
    public Queue<E> enQueue(E t);
    //Removes the element at the beginning of the immutable queue, and returns the new queue.
    public Queue<E> deQueue();
    public E head();
    public boolean isEmpty();
}
