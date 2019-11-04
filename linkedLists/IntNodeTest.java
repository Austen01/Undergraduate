public class IntNodeTest{
    public static void main(String[] args) {

        int valueToSearch = 2; //change this to search for different values


        IntNode n1 = new IntNode(1);
        System.out.println("\nFIRST LINKED LIST\n" + n1.toString());
        n1.addNodeAfterThis(2);
        n1.addNodeAfterThis(3);
        n1.addNodeAfterThis(4);
        n1.addNodeAfterThis(5);
        n1.addNodeAfterThis(6);
        n1.addNodeAfterThis(7);
        System.out.println(n1.toString());
        n1.removeNodeAfterThis();
        System.out.println(n1.toString());
        n1.removeNodeAfterThis();
        System.out.println(n1.toString());
        n1.removeNodeAfterThis();
        System.out.println(n1.toString());
        n1.removeNodeAfterThis();
        System.out.println(n1.toString());

        if(n1.search(n1.head, valueToSearch)){
            System.out.println("n1 linked list contains the value " + valueToSearch + "\n");
        }else{
            System.out.println("n1 linked list does not contain the value " + valueToSearch + "\n");
        }
        

        IntNode n2 = new IntNode();
        System.out.println("\nSECOND LINKED LIST\n" + n2.toString());
        n2.addNodeAfterThis(9);
        n2.addNodeAfterThis(8);
        n2.addNodeAfterThis(7);
        n2.addNodeAfterThis(6);
        n2.addNodeAfterThis(5);
        n2.addNodeAfterThis(4);
        System.out.println(n2.toString());
        System.out.println("List n2 contains: " + n2.listLength(n2.head) + " nodes\n");
        n2.removeNodeAfterThis();
        System.out.println(n2.toString());
        n2.removeNodeAfterThis();
        System.out.println(n2.toString());
        System.out.println("List n2 contains: " + n2.listLength(n2.head) + " nodes\n");


    }
}