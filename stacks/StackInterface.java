/**
 * Generic interace to implement a stack
 * @author Austen Hill
 * @since Oct-15-2019
 * @param <E> data type to be implemented
 */

public interface StackInterface<E> {
    void push(E item);
    E pop();
    E top();
    int size();
    boolean isEmpty();
}