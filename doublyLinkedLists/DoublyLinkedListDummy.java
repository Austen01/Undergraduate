/**
 * Lab 7 Doubly Linked List with dummy head and tail
 * @author Austen Hill
 * @since 09-Oct-2019
 */

public class DoublyLinkedListDummy{

    /**
     * instance variables
     */
    DIntNode head;
    DIntNode tail;

    /**
     * @return the head
     */
    public DIntNode getHead(){
        return this.head;
    }

    /**
     * @return the tail
     */
    public DIntNode getTail() {
        return tail;
    }

    /**
     * @param node the new node to point the head at
     */
    public void setHead(DIntNode node) {
        this.head.setNext(node);
    }

    /**
     * @param node new node to point the tail at
     */
    public void setTail(DIntNode node) {
        this.tail.setPrev(node);
    }

    /**
     * no argument constructor to link dummy head and dummy tail together
     */
    DoublyLinkedListDummy(){
        head = new DIntNode();
        tail = new DIntNode();
        head.setNext(tail);
        tail.setPrev(head);
    }

    /**
     * Time Complexity: O(1)
     * Adds a new node to the end of the linked list before the dummy tail
     * @param element the data to store in the new node
     *                adds a new node to the end of the doubly linked list
     */
    public void addEnd(int element){
        DIntNode newNode = new DIntNode(element);
        newNode.setPrev(this.tail.getPrev());
        this.tail.getPrev().setNext(newNode);
        newNode.setNext(this.tail);
        this.tail.setPrev(newNode);
    }

    /**
     * Time Complexity: O(1)
     * removes the first node in the list (the node that the dummy head points to)
     * precondition is that the head does not link directly to the tail
     */
    public void removeFromHead(){
        if(this.head.getNext() != this.tail){
            this.head.setNext(this.head.getNext().getNext());
            this.head.getNext().setPrev(this.head);
        }
    }

    /**
     * @return a two line string with the data of the list
     *         starting from the head and from the tail
     * 
     *         ex. head <-> node <-> node <-> tail
     *             tail <-> node <-> node <-> head
     */
    public String toString(){
        DIntNode cursor1 = this.head.getNext();
        DIntNode cursor2 = this.tail.getPrev();
        String data = "(head) <-> ";
        String link = " <-> ";

        while(cursor1.getNext() != null){
            data += cursor1.getData();
            data += link;
            cursor1 = cursor1.getNext();
        }
        data += "(tail)\n(tail) <-> ";
        while(cursor2.getPrev() != null){
            data += cursor2.getData();
            data += link;
            cursor2 = cursor2.getPrev();
        }
        data += "(head)\n";
        return data;
    }

    /**
     * Time Complexity: O(n) where n = # of nodes in the list
     * Returns the frequency that the integer e occures in the linked list
     * @param e an integer to count the frequency of in the doubly linked list
     * @return number of occurences
     */
    public int countOccurences(int e){
        int occurences = 0;
        DIntNode cursor = this.head.getNext();
        while(cursor.getNext() != null){
            if(cursor.getData() == e) occurences++;
            cursor = cursor.getNext();
        }
        return occurences;
    }

    /**
     * Time Complexity: O(n) where n = # of nodes in the list
     * Remove all nodes containing integer e
     * @param e remove all nodes that contain the integer e
     * @return true if any nodes were removed, false if no nodes removed
     * @precondition the head does not directly link to the tail
     * @postcondition the linked list will not have any nodes containing e
     */
    public boolean removeAll(int e){
        boolean removed = false;
        if(this.head.getNext() != this.tail){
            DIntNode cursor = head.getNext();
            while(cursor.getNext() != null){
                if(cursor.getData() == e){
                    cursor.getPrev().setNext(cursor.getNext());
                    cursor.getNext().setPrev(cursor.getPrev());
                    removed = true;
                }
                cursor = cursor.getNext();
            }
        
        }
        return removed;
    }

    /**
     * Time Complexity: O(n) where n = endIdx in relation to 0
     * Generate a sub-list from the calling list from [beginIdx, endIdx)
     * @param beginIdx starting index to copy original list to sub-list (included)
     * @param endIdx ending index for copying list (excluded)
     * @return DoublyLinkedListDummy sub-list copied from the calling list from beginIdx to endIdx
     * @precondition •beginIdx is non-negative
     *                •beginIdx is smaller than the list length
     *                •beginIdx is smaller or equal to endIdx
     */
    public DoublyLinkedListDummy subList(int beginIdx, int endIdx){
        if((beginIdx >= 0) && (beginIdx <= endIdx)){
            DIntNode cursor = head.getNext();
            DoublyLinkedListDummy newList = new DoublyLinkedListDummy();
            if(this.head.getNext() == this.tail) return newList;
            int index = 0;
            while(cursor.getNext() != null){
                if(index >= beginIdx && beginIdx < endIdx){
                    newList.addEnd(cursor.getData());
                }
                cursor = cursor.getNext();
                index ++;
            }
            return newList;
        } 
        return null;
    }

    /**
     * @return the number of nodes in the list excluding the dummy nodes
     */

     public int getSize(){
         if(this.head.getNext() == this.tail) return 0;
         else{
             int count = 0;
             DIntNode cursor = this.head.getNext();
             while(cursor.getNext() != null){
                count ++;
                cursor = cursor.getNext();
             }
             return count;
         }
     }

    /** 
     * Time Complexity: O(n) where n = the number of nodes in the linked list
     * prints each unique data value in the list and the frequency of that value
     */
    public void printStatistics(){
        if(this.head.getNext() == this.tail) System.out.println("\nEmpty List");
        else{
            DoublyLinkedListDummy temp = this.subList(0, this.getSize() + 1);
            DIntNode cursor = temp.head.getNext();
            System.out.println("Number      Frequency");
            while(cursor.getNext() != null){
                System.out.println("  " + cursor.getData() + "             " + temp.countOccurences(cursor.getData()));
                temp.removeAll(cursor.getData());
                cursor = cursor.getNext();
            }
        }
    }


    public static void main(String[] args) {

        DoublyLinkedListDummy d1 = new DoublyLinkedListDummy();
        d1.addEnd(1);
        d1.addEnd(2);
        d1.addEnd(8);
        d1.addEnd(7);
        d1.addEnd(8);
        d1.addEnd(6);
        System.out.println("\nFirst Doubly Linked List:\n" + d1.toString());
        System.out.println("The number 8 occurs " + d1.countOccurences(8) + " time(s).\n");
        System.out.println("The number 0 occurs " + d1.countOccurences(0) + " time(s).\n");
        System.out.println("Removed nodes with the value of 2: " + d1.removeAll(2));
        System.out.println("Removed nodes with the value of 9: " + d1.removeAll(9));
        System.out.println("\nFirst List after removal of nodes containing e:\n" + d1.toString());
        System.out.println("Removing from head...");
        d1.removeFromHead();
        System.out.println("First list after removal from head:\n" + d1.toString());
        DoublyLinkedListDummy d2 = d1.subList(2, d1.getSize() + 1);
        System.out.println("Second sub-list copied from first list:\n" + d2.toString());
        d1.printStatistics();


    }


}