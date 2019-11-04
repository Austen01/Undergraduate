/**
 * main test for array queue and list queue
 * @author Austen Hill
 * @since Oct-21-2019
 */

 public class QueueTest{
     public static void main(String[] args) {
         LinkedQueue<Integer> l1 = new LinkedQueue<>();
         System.out.println("Linked List Queue:\n------------------");
         System.out.println("ListQueue is empty: " + l1.isEmpty());
         l1.enqueue(1); System.out.println("enqueue 1");
         l1.enqueue(2);System.out.println("enqueue 2");
         System.out.println("ListQueue front: " + l1.front());
         System.out.println("Deque from ListQueue: " + l1.dequeue());
         System.out.println("ListQueue front: " + l1.front());
         l1.enqueue(3);System.out.println("enqueue 3");
         l1.enqueue(4);System.out.println("enqueue 4");
         System.out.println("Deque from ListQueue: " + l1.dequeue());
         System.out.println("ListQueue front: " + l1.front());
         System.out.println("ListQueue is empty: " + l1.isEmpty());
         System.out.println("The size of the ListQueue is: " + l1.size());

         ArrayQueue<Integer> a1 = new ArrayQueue<>();
         System.out.println("\nArray Queue:\n------------");
         System.out.println("ArrayQueue is empty: " + a1.isEmpty());
         a1.enqueue(1); System.out.println("enqueue 1");
         a1.enqueue(2);System.out.println("enqueue 2");
         System.out.println("ArrayQueue front: " + a1.front());
         System.out.println("Deque from ArrayQueue: " + a1.dequeue());
         System.out.println("ArrayQueue front: " + a1.front());
         a1.enqueue(3);System.out.println("enqueue 3");
         a1.enqueue(4);System.out.println("enqueue 4");
         a1.enqueue(5);System.out.println("enqueue 5");
         a1.enqueue(6);System.out.println("enqueue 6");
         a1.enqueue(7);System.out.println("enqueue 7");
         a1.enqueue(8);System.out.println("enqueue 8");
         a1.enqueue(9);System.out.println("enqueue 9");
         System.out.println("Deque from ArrayQueue: " + a1.dequeue());
         System.out.println("Deque from ArrayQueue: " + a1.dequeue());
         a1.enqueue(10);System.out.println("enqueue 10");
         a1.enqueue(11);System.out.println("enqueue 11");
         a1.enqueue(12);System.out.println("enqueue 12");
         System.out.println("Deque from ArrayQueue: " + a1.dequeue());
         System.out.println("Deque from ArrayQueue: " + a1.dequeue());
         System.out.println("Deque from ArrayQueue: " + a1.dequeue());
         System.out.println("Deque from ArrayQueue: " + a1.dequeue());
         System.out.println("Deque from ArrayQueue: " + a1.dequeue());
         System.out.println("Deque from ArrayQueue: " + a1.dequeue());
         System.out.println("ArrayQueue front: " + a1.front());
         System.out.println("ArrayQueue is empty: " + a1.isEmpty());
         System.out.println("The size of the ArrayQueue is: " + a1.size());


        Palindrome pal = new Palindrome();
        System.out.println("\nCheck for word-by-word palindromes:\n---------------------------------");
        String p1 = "this is not a palindrome";
        String p2 = "You can cage a swallow, can’t you, but, you can’t swallow a cage, can you?";
        String p3 = "ye$s, 6no y*e=s"; // should be true since @ - % @ & are not letters. is equal to "yes no yes"
        System.out.println("p1 is a palindrome: " + pal.checkPalindrome(p1));
        System.out.println("p2 is a palindrome: " + pal.checkPalindrome(p2));
        System.out.println("p3 is a palindrome: " + pal.checkPalindrome(p3));
    
     }
 }