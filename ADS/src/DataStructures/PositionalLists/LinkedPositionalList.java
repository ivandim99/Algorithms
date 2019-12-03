package DataStructures.PositionalLists;

public class LinkedPositionalList<E> implements PositionalList<E> {

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public LinkedPositionalList() {
        header = new Node<>(null,null,null);
        trailer = new Node<>(null,header,null);
        header.setNext(trailer);
    }

    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if(!(p instanceof Node)) throw new IllegalArgumentException("Invalid p");
        Node<E> node = (Node<E>) p;
        if(node.getNext() == null)
            throw new IllegalArgumentException("p is no longer in the list");
        return node;
    }

    private Position<E> position(Node<E> node) {
        if(node == header || node == trailer)
            return null;
        return node;
    }

    //public

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Position<E> first() {
        return position(header.getNext());
    }

    public Position<E> last() {
        return position(trailer.getPrev());
    }

    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    //private

    private Position<E> addBetween(E e,Node<E> pred,Node<E> succ) {
        Node<E> newNode = new Node<>(e,pred,succ);
        pred.setNext(newNode);
        succ.setPrev(newNode);
        size++;
        return newNode;
    }

    //public updates

    public Position<E> addFirst(E e) {
        return addBetween(e,header,header.getNext());
    }

    public Position<E> addLast(E e) {
        return addBetween(e,trailer.getPrev(),trailer);
    }

    public Position<E> addBefore(Position<E> p,E e) throws IllegalArgumentException{
        Node<E> node = validate(p);
        return addBetween(e,node.getPrev(),node);
    }

    public Position<E> addAfter(Position<E> p,E e) throws IllegalArgumentException{
        Node<E> node = validate(p);
        return addBetween(e,node,node.getNext());
    }

    public E set(Position<E> p,E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E ret = node.getElement();
        node.setElement(e);
        return ret;
    }

    public E  remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        E answer = node.getElement();
        node.setElement(null);
        node.setNext(null);
        node.setPrev(null);
        return answer;
    }
}