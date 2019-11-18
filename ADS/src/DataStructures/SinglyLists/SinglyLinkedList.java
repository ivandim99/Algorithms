package DataStructures.SinglyLists;

import DataStructures.SinglyLists.Node;

public class SinglyLinkedList<E> {

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    public SinglyLinkedList() {}
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public E first() {
        return head.getElement();
    }
    public E last() {
        return tail.getElement();
    }

    //some methods to modify the SLL.

    public void addFirst(E e) {
        Node<E> newest = new Node<>(e,head);
        if(size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e,null);
        if(isEmpty()) {
            head = newest;
        }
        else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if(isEmpty()) return null;
        E ret = head.getElement();
        head = head.getNext();
        size--;
        if(size==0) {
            tail = null;
        }
        return ret;
    }

}
