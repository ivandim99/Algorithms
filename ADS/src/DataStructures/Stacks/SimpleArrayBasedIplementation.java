package DataStructures.Stacks;

/**
 * FILO.
 * @param <E>
 */
public class SimpleArrayBasedIplementation<E> implements Stack<E> {
    public static final int CAPACITY = 1000;
    private E[] data;
    private int t = -1;     //index of top element in stack

    public SimpleArrayBasedIplementation() {
        this(CAPACITY);
    }

    public SimpleArrayBasedIplementation(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return (t + 1);
    }

    public boolean isEmpty() {
        return t == -1;
    }

    public void push(E e) throws IllegalStateException {
        if(size() == data.length) throw new IllegalStateException("Stack is full");
        data[++t] = e;
    }

    public E top() {
        if(isEmpty()) return null;
        return data[t];
    }

    public E pop() {
        if(isEmpty()) return null;
        E answer = data[t];
        data[t] = null;
        t--;
        return answer;
    }

}

