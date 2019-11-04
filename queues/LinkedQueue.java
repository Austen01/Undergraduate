import java.util.EmptyStackException;

/**
 * Generic queue implementation using singly linked list
 * @author Austen Hill
 * @since Oct-21-2019
 * @param <E> data type to be implemented
 */

 public class LinkedQueue<E> implements QueueInterface<E>{
    SNode<E> front;
    SNode<E> rear;
    int qCount;

    /**
     * no arguement constructor
     */
    LinkedQueue(){
        front = rear = null;
        qCount = 0;
    }

    /**
     * single arguement constructor
     * @param initData initialize linked queue with front containing initData
     */
    LinkedQueue(E initData){
        front = rear = new SNode<E>(initData);
        count = 1;
    }

    /**
     * enqueue a new item to the list
     * @param item the value of the item to enqueue
     */
    public void enqueue(E item){
        SNode<E> tmp = rear;
        rear = new SNode<E>(item, null);
        if(this.isEmpty()) front = rear;
        else tmp.next = rear;
        qCount++;
    }

    /**
     * dequeue the front item from the list
     * @return the front item's data
     * @precondition the queue must not be empty
     */
    public E dequeue(){
        if(!this.isEmpty()){
            E item = front.data;
            front = front.next;
            qCount--;
            if(this.isEmpty()) rear = null;
            return item;
        }
        else{
            System.out.println("The queue is empty");
            throw new EmptyStackException();
        }
    }

    /**
     * check the data of the front item in the queue
     * @return the data of the front item
     */
    public E front(){
        if(this.isEmpty()) return null;
        else{
            return front.data;
        }
    }

    /**
     * check the number of items in the queue
     * @return qCount the number of items queued
     */
    public int size(){
        return qCount;
    }

    /**
     * @return true if 1 or more items are queued
     */
    public boolean isEmpty(){
        return(qCount == 0);
    }
 }