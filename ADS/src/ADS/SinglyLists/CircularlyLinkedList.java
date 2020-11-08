package ADS.SinglyLists;


/**
 * Another LinkedList data structure which also uses nodes but unlike SLL
 * it's last element the tail points to the head instead of null.It supports
 * one additional method besides those from SLL -> rotate()
 */
public class CircularlyLinkedList<E> {
    private Node<E> tail = null;
    private int size = 0;

    public CircularlyLinkedList() {}

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public E first() {
        if(isEmpty()) return null;
        return tail.getNext().getElement();
    }
    public E last() {
        if(isEmpty()) return null;
        return tail.getElement();
    }

    public void rotate() {
        if(tail != null) {
            tail = tail.getNext();
        }
    }
    public void addFirst(E e) {
        if (isEmpty()) {
            tail = new Node<>(e, null); //if empty then create new node which will be the tail and it will point to itself
            tail.setNext(tail);     //here we set that
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }
    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }
    public E removeFirst() {
        if(isEmpty()) return null;
        Node<E> head = tail.getNext();
        if(head == tail) tail = null;
        else
            tail.setNext(head.getNext());
        size--;
        return head.getElement();
    }
}
