/**
 * Implementation of generic singly linked list stack
 * @author Austen Hill
 * @since Oct-15-2019
 * @param <E> data type to be implemented
 */

import java.util.EmptyStackException;

public class LinkStack<E> implements StackInterface<E>{

    // reference to the top of the stack
    SNode<E> top;

    /**
     * No arguement constructor
     */
    public LinkStack(){
        top = null;
    }

    //Single arguement constructor
    public LinkStack(E data){
        top = new SNode<E>(data);
    }

    /**
     * Pushes a new node onto the top of the stack
     * @param data the data to set in the new top node
     */
    public void push(E data){
        top = new SNode<E>(data, top);
    }

    /**
     * Pops the top node off of the stack
     * @return the data of the top node in the stack and remove that node
     */
    public E pop(){
        if(top == null){
            throw new EmptyStackException();
        }
        E data = top.data;
        top = top.next;
        return data;
    }

    /**
     * @return the data of the top node if the stack is not empty
     * @throws EmptyStackException if top is null
     */
    public E top(){
        if(top != null){
            return top.data;
        }
        else throw new EmptyStackException();
    }

    /**
     * @return the number of nodes in the stack
     */
    public int size(){
        int nodes = 0;
        if(top == null) return 0;
        SNode<E> cursor = top;
        while(cursor != null){
            nodes++;
            cursor = cursor.next;
        }
        return nodes;
    }

    /**
     * @return true if the stack is empty, else false
     */
    public boolean isEmpty(){
        return(top == null);
    }

}