package singlylinkedlist;

/**
 * Created by AmitAgarwal on 5/6/20.
 */
public class App {

    public static void main(String[] args) {
        Node nodeA = new Node();
        nodeA.data = 4;

        Node nodeB = new Node();
        nodeB.data = 3;

        Node nodeC = new Node();
        nodeC.data = 7;

        Node nodeD = new Node();
        nodeD.data = 8;


        /**
         * Making a reference to next node (object in memory)
         */
        nodeA.next = nodeB ;
        nodeB.next = nodeC;
        nodeC.next = nodeD;

        // finding length of linked list
        int count = length(nodeA);
        System.out.println(count);

    }

    public static int length(Node aNode){
        int count = 0;
        while(aNode!=null){
            count++;
            // increment it to next node
            aNode = aNode.next;
        }
        return count;
    }

}
