package com.sbsatter.paypaydemo.impl;

import com.sbsatter.paypaydemo.solution.Node;
import com.sbsatter.paypaydemo.solution.Queue;

public class ImmutableQueue<E> implements Queue<E> {

    Node<E> head, tail;
    private int size;

    public ImmutableQueue() {
        head = new Node<E>();
        tail = head;
        size = 0;
    }

    public ImmutableQueue(Node<E> head, Node<E> tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    public Queue<E> enQueue(E o) {
        Node<E> object = new Node<E>();
        object.setElement(o);

        Node<E> tail = this.tail;
        int size = this.size;

        tail.setNext(object);
        tail = object;
        size++;

        return new ImmutableQueue<E>(head, tail, size);
    }

    public Queue<E> deQueue() {

        Node<E> head = this.head;
        int size = this.size;

        if (head.getNext() != null) {
            Node<E> next = head.getNext();
            head.setNext(next.getNext());
            size--;
        }
        return new ImmutableQueue<E>(head, tail, size);
    }

    public E head() {
        if (head.getNext() == null) {
            return null;
        }
        return head.getNext().getElement();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ImmutableQueue{" +
                "head=" + head
                );
        Node head = this.head;
        int i = 0;
        while (head.getNext() != null) {
            head = head.getNext();
            stringBuilder.append(String.format(", [%d] => %s", i++, head.getElement()));
        }

        stringBuilder.append(", size=").append(size).append('}');
        return stringBuilder.toString();
    }
}
