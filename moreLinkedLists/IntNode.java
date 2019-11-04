public class IntNode{

//node implementation
    class Node{
        // two instance variables for the data and link of each node
        private int data;
        private Node next;

        //default constructor with no parameters
        public Node(){
            this.data = 0;
            this.next = null;
        }//default constructor

        /**
         * @param _data the data to set
         * @param _node the link to set
         */
        public Node(int _data, Node _node){
            this.data = _data;
            this.next = _node;
        }//constructor

        /**
         * @return link to next
         */
        public Node getNext() {
            return this.next;
        }//getNext

        /**
         * @return data of node
         */
        public int getData() {
            return this.data;
        }//getData

        /**
         * @param value the data to set
         */
        public void setData(int value) {
            this.data = value;
        }//setData

        /**
         * @param link the next link to set
         */
        public void setNext(Node link) {
            this.next = link;
        }//setNext
    }//node class


//class implementation
    Node head;
    
    public IntNode(){
        this.head = new Node();
    }

    /**
     * @param data the data to create a new node with
     */
    public IntNode(int data){
        this.head = new Node(data, null);
    }

    @Override
    // toString method to print the data of each node from the activating node to the tail
    public String toString() {
        String listData = "";
        Node cursor = this.head;
        while(cursor != null){
            listData += cursor.getData();
            listData += " ";
            cursor = cursor.getNext();
        }
        return listData;
    }//toString

    //add a new node after the current one
    public void addNodeAfterThis(int newData){
        Node current = head;
        Node temp = current.getNext();
        Node newNode = new Node(newData, temp);
        current.setNext(newNode); 
    }//add after

    //remove the node after the current one
    public void removeNodeAfterThis(){
        if((this.head.getNext() != null)){
            //if there is only one node after the current one set the current.next to null
            if(this.head.getNext().getNext() == null){
                this.head.setNext(null);
            }
            //if there are more than one node after the current one then set the current link to the link of the node after current's link
            else{
                this.head.setNext(this.head.getNext().getNext());
            }
        }
    }//remove after

    // return the length of a linked list from a given head
    public static int listLength(Node head){
        Node cursor = head;
        int count = 0;
        while(cursor != null){
            count += 1;
            cursor = cursor.getNext();
        }
        return count;
    }//list length

    /**
     * @param head the head node of the list
     * @param data the data to check if the list contains
     * @return true if the list contains data and false if not
     * @custom.precondition head is not null
     */
    public static boolean search(Node head, int data){
        Node cursor = head;
        while(cursor != null){
            if(cursor.getData() == data){
                return true;
            }//endif
            cursor = cursor.getNext();
        }//end while
        return false;
    }//search


    /**
     * @param head the head node of the list
     * @return the number of even elements in the linked list from the given head
     * @custom.precondition the linked list must not contain a cycle
     */
    public static int listEvenNumber(Node head){
        int evenElementCount = 0;
        if(head == null){ // if the head is null return 0
            return 0;
        }else{
            Node cursor = head;
            while(cursor != null){ //loop through the list starting from the head until null is reached
                if(cursor.getData()%2 == 0){ // if the element modulo 2 is 0 then increment the even element counter
                    evenElementCount++;
                }
                cursor = cursor.getNext();
            }
            return evenElementCount;
        }
    }//listEvenNumber

    /**
     * @param newData the data to add to the new node
     * @custom.precondition the linked list must not contain a cycle
     */
    public void addToEnd(int newData){
        if(this.head == null){ //if the list is empty make a new node and point the head to the new node
            Node newNode = new Node(newData, null);
            this.head = newNode;
        }else{
            Node cursor = this.head;
            while(cursor.getNext() != null){ //crawl to the end of the list
                cursor = cursor.getNext();
            }
            // make a new node and point the last node to the new one
            Node newNode = new Node(newData, null);
            cursor.setNext(newNode);
        }
    }//addToEnd

    /**
     * @param newData data to create new node with
     */
    public void addToFront(int newData){
        if(this.head != null){
            Node newNode = new Node(newData, this.head);
            this.head = newNode;
        }else{
            Node newNode = new Node(newData, null);
            this.head = newNode;
        }
    }//addToFront


    /**
     * @param head the head of the linked list
     * @param num specifies the last n elements in the list
     * @return sum: the sum of the last n elements in the list
     * @custom.precondition the linked list must not contain a cycle
     */
    public static int sumLast(Node head, int num){
        if(head == null){ //if the list is empty return 0
            return 0;
        }else{
            int sum = 0;
            Node cursor = head;
            if(num >= listLength(head)){ //if the list is smaller than or equal to num then add up all elements in the list
                while(cursor != null){
                    sum += cursor.getData();
                    cursor = cursor.getNext();
                }
                return sum;
            }else{ // if the list is larger than num then move through the list until last n elements are reached
                int listLength = listLength(head);
                while(cursor != null){
                    if(listLength <= num){
                        sum += cursor.getData();
                    }
                    listLength--;
                    cursor = cursor.getNext();
                }
                return sum;
            }
        }
    }//sumLast


    /**
     * @param head the head of the linked list
     * @return IntNode with head pointing to new linked list of copied odd elements
     * @custom.precondition the linked list must not contain a cycle
     */
    public static IntNode copyOdd(Node head){
        if(head != null){ // create new IntNode list with a head pointing to null
            IntNode copiedList = new IntNode();
            copiedList.head = null;
            Node cursor = head;
            while(cursor != null){ // crawl through the list starting at head and add each odd element to the end of the new IntNode list
                if(cursor.getData()%2 != 0){
                    copiedList.addToEnd(cursor.getData());
                }
                cursor = cursor.getNext();
            }
            return copiedList;
        }else{ // if head is null return null
            return null;
        }
    }//copyOdd 



    /**
     * @param head the head of the linked list
     * @param e remove all elements with the value of e
     * @return IntNode list will all elements containing e removed
     * @custom.precondition the linked list must not contain a cycle
     */
    public static IntNode removeAll(Node head, int e){
        if(head != null){ // create new IntNode list with a head pointing to null
            Node cursor = head;
            IntNode removed = new IntNode();
            removed.head = null;
            while(cursor != null){ // add each element that does not contain e to a new list
                if(cursor.getData() != e){
                    removed.addToEnd(cursor.getData());
                }
                cursor = cursor.getNext();
            }
            return removed;
        }else{ // if head is null return null
            return null;
        }
    }//removeAll 

    

    /**
     * @param head the head of the linked list
     * @return IntNode list with all elements containing e removed
     * @custom.precondition the linked list must not contain a cycle
     */
    public static IntNode reverse(Node head){
        if(head != null){ // create a new IntNode list with head pointing to null
            IntNode reversed = new IntNode();
            reversed.head = null;
            Node cursor = head;
            while(cursor != null){ // add each element in the original list to the new list in reversed order
                reversed.addToFront(cursor.getData());
                cursor = cursor.getNext();
            }
            return reversed;
        }else{ //if head is null return null
            return null;
        }
    }//reverse 


    /**
     * @param head the head of the list to check for a cycle
     * @return true if a cycle exists and false if no cycle exists
     */
    public static boolean hasCycle(Node head){
        Node fastCursor = head;
        Node slowCursor = head;
        //crawl through the list with fastCursor hitting every other node and slowCursor hitting every node
        //if a cycle exists the fastCursor will reach the slowCursor
        while(fastCursor != null && slowCursor.getNext() != null){ 
            fastCursor = fastCursor.getNext().getNext();
            slowCursor = slowCursor.getNext();
            if(slowCursor == fastCursor){
                return true;
            }
        }
        return false;
    }//hasCycle

    /**
     * @param head the head of the list to create a cycle in
     */
    public void createCycle(Node head){
        head.getNext().getNext().getNext().setNext(head.getNext());
    }//createCycle
    
}//class