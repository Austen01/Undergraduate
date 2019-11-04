/**
 * Generic node class for singly linked list stack
 * @author Austen Hill
 * @since Oct-15-2019
 * @param <E> data type to be implemented
 */

public class SNode<E>{

    /**
     * instance variables
     */
    E data;
    SNode<E> next;

    /**
     * No arguement constructor for generic node
     */
    public SNode(){
        data = null;
        next = null;
    }

    /**
     * Single arguement constructor with only data
     * @param initData data to store in new node
     */
    public SNode(E initData){
        data = initData;
        next = null;
    }

    /**
     * Constructor with next link and data parameters
     * @param initData data to store in new node
     * @param link link to the next node
     */
    public SNode(E initData, SNode<E> link){
        data = initData;
        next = link;
    }

}