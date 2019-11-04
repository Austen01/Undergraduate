/**
 * Testing of linked list stack and arraylist stack
 * @author Austen Hill
 * @since Oct-15-2019
 */
public class StackTest{
    public static void main(String[] args) {
        System.out.println("Arraylist stack test:\n-----------------------");
        ArraylistStack<Integer> s = new ArraylistStack<>();
        System.out.println("Size of arraylist stack: " + s.size());
        s.push(1);
        System.out.println("Size of arraylist stack: " + s.size());
        System.out.println("Top of arraylist stack: " + s.top());
        s.push(2);
        System.out.println("Size of arraylist stack: " + s.size());
        System.out.println("Top of arraylist stack: " + s.top());
        s.push(3);
        System.out.println("Size of arraylist stack: " + s.size());
        System.out.println("Top of arraylist stack: " + s.top());
        System.out.println("Popping from arraylist stack: " + s.pop());
        System.out.println("Size of arraylist stack: " + s.size());
        System.out.println("Top of arraylist stack: " + s.top());

        System.out.println("\nLinked list stack test:\n-----------------------");
        LinkStack<Integer> l = new LinkStack<>();
        System.out.println("Size of linked list stack: " + l.size());
        l.push(1);
        System.out.println("Size of linked list stack: " + l.size());
        System.out.println("Top of linked list stack: " + l.top());
        l.push(2);
        System.out.println("Size of linked list stack: " + l.size());
        System.out.println("Top of linked list stack: " + l.top());
        l.push(3);
        System.out.println("Size of linked list stack: " + l.size());
        System.out.println("Top of linked list stack: " + l.top());
        System.out.println("Popping from linked list stack: " + l.pop());
        System.out.println("Size of linked list stack: " + l.size());
        System.out.println("Top of linked list stack: " + l.top());
        
    }
}