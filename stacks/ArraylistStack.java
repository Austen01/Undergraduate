/**
 * Implementation of generic arraylist stack
 * @author Austen Hill
 * @since Oct-15-2019
 * @param <E> data type to be implemented
 */

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArraylistStack<E> implements StackInterface<E>{

    /**
     * instance variables
     * stack is the arraylist holding the stack
     * top is the index of the 'top' item
     */
    ArrayList<E> stack;

    /**
     * No arguement constructor
     */
    public ArraylistStack(){
        stack = new ArrayList<E>();
    }

    /**
     * Single arguement constructor
     * @param data value of item to store in the stack
     */
    public ArraylistStack(E data){
        stack = new ArrayList<E>();
        stack.add(data);
    }

    /**
     * pushes a new item to the top of the stack
     * @param data the value of the item to push
     */
    public void push(E data){
        stack.add(data);
    }

    /**
     * pops the top item off of the stack and returns the value
     * @return the value of the top item
     */
    public E pop(){
        if(!isEmpty()){
            return stack.remove(size()-1);
        }
        else throw new EmptyStackException();
    }

    /**
     * @return the value of the top element in the stack
     */
    public E top(){
        if(!isEmpty()){
            return stack.get(size()-1);
        }
        else throw new EmptyStackException();
    }

    /**
     * @return the value of the top element in the stack
     */
    public E top(int index){
        if(!isEmpty()){
            return stack.get(index);
        }
        else throw new EmptyStackException();
    }

    /**
     * @return the number of elements in the stack
     */
    public int size(){
        return stack.size();
    }

    /**
     * @return true if there are 0 items in the stack, else false
     */
    public boolean isEmpty(){
        return(stack.size() == 0);
    }

}