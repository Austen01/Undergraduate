public class IntNodeAdvancedTest{
    public static void main(String[] args) {

        IntNode list1 = new IntNode(3);
        list1.addToEnd(12);
        list1.addToEnd(15);
        list1.addToEnd(54);
        list1.addToEnd(54);
        list1.addToEnd(54);
        list1.addToEnd(11);
        list1.addToEnd(0);

        System.out.println("list: " + list1.toString());
        System.out.println("number of nodes: " + list1.listLength(list1.head));

        System.out.println("number of even numbers: " + list1.listEvenNumber(list1.head));

        System.out.println("sum of last: " + list1.sumLast(list1.head, 4));

        IntNode copiedList = list1.copyOdd(list1.head);
        System.out.println("copied list: " + copiedList.toString());

        IntNode removed = list1.removeAll(list1.head, 54);
        System.out.println("List with e elements removed: " + removed.toString());

        IntNode reversed = list1.reverse(list1.head);
        System.out.println("reversed list: " + reversed.toString());

        //list1.createCycle(list1.head); //<-- uncommment this to create a cycle in the list for testing hasCycle()
        System.out.println("The list is cyclic: " + list1.hasCycle(list1.head));


    }
}