package linkedlist;

/**
 * Created by AmitAgarwal on 4/1/19.
 */
public class Application {
    public static void main(String [] args){
        Node nodeA = new Node();
        Node nodeB = new Node();
        Node nodeC = new Node();
        Node nodeD = new Node();

        nodeA.data = 4;
        nodeB.data = 3;
        nodeC.data = 7;
        nodeD.data = 8;

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;

        System.out.println( "Length of Node A :: " + lengthLinkedList(nodeA));
        System.out.println( "Length of Node B :: " + lengthLinkedList(nodeB));
        System.out.println( "Length of Node C :: " + lengthLinkedList(nodeC));
        System.out.println( "Length of Node D :: " + lengthLinkedList(nodeD));
    }

    /**
     *
     * @param node
     * @return
     *
     * Checking the length of linkedList
     */
    private static int lengthLinkedList(Node node){
        int size = 0;
        Node currentNode = node;
        while(currentNode != null){
            currentNode = currentNode.next;
            size++;
        }
        return size;
    }
}
