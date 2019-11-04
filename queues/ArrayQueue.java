import java.util.EmptyStackException;

/**
 * Generic queue implementation using an array
 * @author Austen Hill
 * @since Oct-21-2019
 * @param <E> data type to be implemented
 */

 public class ArrayQueue<E> implements QueueInterface<E>{
     /**
      * instance variables:
      * front: index of first queued item
      * rear: index of last queued item
      * size: number of queued items
      */
     E data[];
     int front, rear, size;

     /**
      * constructor creates array of size 10 and initializes instance variables to 0
      */
     public ArrayQueue(){
        data = (E[]) new Object[10];
        front = rear = size = 0;
     }

     /**
      * enqueue a new item
      * @param item data to queue
      */
     public void enqueue(E item){
         //if the array is full, double the length
         if(size == data.length){
            E[] tmp = (E[]) new Object[data.length * 2];
            //if the rear and front are on the same element copy the array from front to end then 0 to rear
            if(front == rear){
                int index = 0;
                for(int i = front; i < data.length; i++){
                    tmp[index] = data[i];
                    index++;
                }
                for(int i = 0; i < rear; i++){
                    tmp[index] = data[i];
                    index++;
                }
                front = 0;
                rear = index;
            }else{
                //if rear is after front then copy directly
                for(int i = 0; i < data.length; i++){
                    tmp[i] = data[i];
                    front = 0;
                    rear = i;
                }
            }
            data = tmp;
         }
         data[rear] = item;
         size++;
         rear = (++rear)%data.length;
     }

     /**
      * 'remove' the front item and return its data
      * @return the data of the front item
      * @precondition the queue must not be empty
      */
     public E dequeue(){
         if(size > 0){
             E item = data[front];
             size--;
             front = (++front)%data.length;
             return item;
         }else throw new EmptyStackException();
     }

     /**
      * @return the data of the front item in the queue
      */
     public E front(){
         return data[front];
     }

     /**
      * @return the number of items in the queue
      */
     public int size(){
         return size;
     }

     /**
      * @return true if there is 1 or more queued items
      */
     public boolean isEmpty(){
         return(size == 0);
     }

 }