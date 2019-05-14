/**
 * Created by AmitAgarwal on 11/23/18.
 */
public class NodeApp {
    public static void main(String [] args){
        //independent nodes
        Node nodeA = new Node();
        nodeA.setData(4);

        Node nodeB = new Node();
        nodeB.setData(3);

        Node nodeC = new Node();
        nodeB.setData(7);

        Node nodeD = new Node();
        nodeB.setData(8);

        //connecting nodes....
        nodeA.setNext(nodeB); //we assign the reference and not values
        nodeB.setNext(nodeC);
        nodeC.setNext(nodeD);

        System.out.println(listLength(nodeD));
    }

    //getting the length of node
    private static int listLength(Node node){
        int length = 0;
        Node currentNode = node;
        while(currentNode != null){
            length++;
            currentNode = currentNode.getNext();
        }

        return  length;

    }
}
