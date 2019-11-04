import java.util.EmptyStackException;
/**
 * class to check if a phrase is a word-by-word palindrome
 * @author Austen Hill
 * @since Oct-21-2019
 * interface and implementation used for linked list stack are below the palindrome class
 */

public class Palindrome{
    
    /**
     * evaluate a phrase to see if it is a word-by-word palindrome
     * @param phrase the sentence or phrase to test
     * @return true if the phrase is a word-by-word palindrome
     */
    public boolean checkPalindrome(String phrase){
        LinkStack<String> stack = new LinkStack<>();
        LinkedQueue<String> queue = new LinkedQueue<>();
        boolean isPalindrome = true;
        //put each word into an array
        String[] wordArray = phrase.split("[\\.,!?;:\"\\s\\r\\n]+");
        for(int i = 0; i < wordArray.length; i++){
            //push each word into a stack and queue ignoring anything other than letters and apostrophe
            stack.push(wordArray[i].replaceAll("[0-9\\@#$%^&*\\(\\)\\-\\_\\+\\=]", ""));
            queue.enqueue(wordArray[i].replaceAll("[0-9\\@#$%^&*\\(\\)\\-\\_\\+\\=]", ""));
        }
        //remove the word from each end and check if they match, if not return false
        while(!stack.isEmpty()){
            if(!(stack.pop().equalsIgnoreCase(queue.dequeue()))) return false;
        }
        return isPalindrome;
    }

}


/**
 * interface and implementation of generic linked list stack
 * @param <E> object data type
 */ 


public interface StackInterface<E> {
    void push(E item);
    E pop();
    E top();
    int size();
    boolean isEmpty();
}

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