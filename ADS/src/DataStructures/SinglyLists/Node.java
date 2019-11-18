package DataStructures.SinglyLists;

/**
 * A nested Node class with parameters element and next.
 * The element is the content of the node.
 * The next is pointing to the next node in the SLL.
 * @param <E>
 */
public  class Node<E> {
    private E element;
    private Node<E> next;
    public Node(E e,Node<E> n) {
        element = e;
        next = n;
    }
    public E getElement() {
        return element;
    }
    public Node<E> getNext() {
        return next;
    }
    public void setNext(Node<E> n) {
        next = n;
    }
}