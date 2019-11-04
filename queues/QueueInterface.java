/**
 * Generic interace to implement a queue
 * @author Austen Hill
 * @since Oct-21-2019
 * @param <E> data type to be implemented
 */

public interface QueueInterface<E> {
    void enqueue(E item);
    E dequeue();
    E front();
    int size();
    boolean isEmpty();
}