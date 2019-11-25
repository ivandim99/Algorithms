package DataStructures.Stacks;

public interface Stack<E> {

    int size(); //number of elements in the stack.

    boolean isEmpty();

    void push(E e);

    E top();

    E pop();

}
