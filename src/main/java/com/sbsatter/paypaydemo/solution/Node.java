package com.sbsatter.paypaydemo.solution;

public class Node<E> {

    private Node<E> prev;
    private E element;
    private Node<E> next;

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" + element + '}';
    }
}
