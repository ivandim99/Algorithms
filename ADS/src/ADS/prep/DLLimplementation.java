package ADS.prep;

class DLList {

    class Node {
        // Each node object has these three fields
        private Object element;
        private Node previous;
        private Node next;

        // Constructor: Creates a Node object with element = e, previous = p and next = n
        Node(Object e, Node p, Node n) {
            element = e;
            previous = p;
            next = n;
        }

        // This function gets Object e as input and sets e as the element of the Node
        public void setElement(Object e) {
            element = e;
        }

        // This function returns the element variable of the Node
        public Object getElement() {
            return element;
        }

        // This function gets Node n as input and sets the next variable of the current Node object as n.
        public void setNext(Node n) {
            next = n;
        }

        // This function returns the next Node
        public Node getNext() {
            return next;
        }

        // This function gets Node p as input and sets the previous variable of the current Node object as p.
        public void setPrevious(Node p) {
            previous = p;
        }

        // This function returns the previous Node
        public Node getPrevious() {
            return previous;
        }
    }

    // Each object in DLList has one field head, which points to the starting Node of DLList.
    private Node head;
    // Each object in DLList has one field tail, which points to the final Node of DLList.
    private Node tail;


    public DLList() {
        head = null;
        tail = null;
    }

    public Object getHead() {
        return head.getElement();
    }

    public Object getTail() {
        return tail.getElement();
    }

    public void addFirst(Object e) {
        Node node = new Node(e, null, head);
        if (head != null) {
            head.setPrevious(node);
            node.setNext(head);
        }
        if (tail == null) {
            tail = node;
        }
        head = node;
    }

    public Object removeFirst() {
        if (head == null) return null;
            Node newHead = head.getNext();
            Object ret = getHead();
            if (newHead != null) {
                newHead.setPrevious(null);
            }
            head = newHead;
            return ret;
    }

    public void addLast(Object e) {
        Node node = new Node(e,tail,null);
        if(tail != null) {
            tail.setNext(node);
            node.setPrevious(tail);
        }
        if(head == null) {
            head = node;
        }
        tail = node;
    }

    public Object removeLast() {
        if(tail == null) return null;
        Node newTail = tail.getPrevious();
        Object ret = getTail();
        if(newTail != null) {
            newTail.setNext(null);
        }
        tail = newTail;
        return ret;
    }

    public int size() {
        if(head == null) return 0;
        int count = 1;
        Node h = head;
        while(h.getNext() != null) {
            h = h.getNext();
            count++;
        }
        return count;
    }

    public void addAtPosition(int pos,Object e) {
        if(pos >= size()) addLast(e);
        else if(pos == 0) addFirst(e);
        else {
            Node node = head.getNext();
            for(int i = 1;i != pos;i++) {
                node = node.getNext();
            }
            Node newest = new Node(e,node.getPrevious(),node);
            node.getPrevious().setNext(newest);
            node.setPrevious(newest);
        }
    }

    public Object removeAtPosition(int pos) {
        if(pos == 0) return removeFirst();
        else if(pos == size() - 1) return removeLast();
        else if(pos >= size()) return null;
        else {
            Node node = head.getNext();
            for(int i = 0;i != pos;i++) {
                node = node.getNext();
            }
            Object removed = node.getElement();
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
            return removed;
        }
    }

    public DLList reverse() {
        DLList reversed = new DLList();
        Node t = tail;
        while(t!=null) {
            reversed.addLast(t.getElement());
            t = t.getPrevious();
        }
        return reversed;
    }
}
