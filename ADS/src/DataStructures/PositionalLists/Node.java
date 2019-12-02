package DataStructures.PositionalLists;

public class Node<E> implements Position<E>{
    private E element;
    private Node<E> next;
    private Node<E> prev;
    public Node(E e, Node<E> p, Node<E> n) {
        element = e;
        prev = p;
        next = n;
    }
    public E getElement() {
        return element;
    }
    public void setElement(E e) {
        element = e;
    }
    public Node<E> getPrev() {
        return prev;
    }
    public Node<E> getNext() {
        return next;
    }
    public void setNext(Node<E> n) {
        next = n;
    }
    public void setPrev(Node<E> p) {
        prev = p;
    }
}
