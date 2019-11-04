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
            data = value;
        }//setData

        /**
         * @param link the next link to set
         */
        public void setNext(Node link) {
            next = link;
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
     * @pre head != null
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

    
}//class