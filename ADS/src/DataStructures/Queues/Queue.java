package DataStructures.Queues;


public interface Queue<E> {

    int size();

    boolean isEmpty();

    void enqueue(E e);

    E first();      //java.util.Queue has peek(),element()

    E dequeue();        //java.util.Queue poll(),remove()

}
