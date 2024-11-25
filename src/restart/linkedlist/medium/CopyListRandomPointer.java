package restart.linkedlist.medium;

class Node {
    int value;
    Node next;
    Node random;

    public Node (int value) {
        this.value = value;
        this.next = null;
        this.random = null;
    }
}
public class CopyListRandomPointer {

    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(8);
        head.next.next = new Node(15);
        head.next.next.next = new Node(16);

        head.random =head.next.next;
        head.next.random = head.next.next.next;
        head.next.next.random = head.next;
        head.next.next.next.random  = head.next.next;

        Node newHead = copyRandomList(head);

        Node current = newHead;

        while (current != null) {
            System.out.println("Node" + current.value);
            if (current.random != null) {
                System.out.println(", Random" + current.random.value);
            } else {
                System.out.println(", Random : null");
            }
            System.out.println();
            current = current.next;
        }
    }

    public static Node copyRandomList (Node head) {
        if (head == null) {
            return null;
        }

        // Step 1 create a copy of existing list and connect both of them
        Node current = head;
        while (current != null) {
            // first create a copy for new list
            Node newNode = new Node(current.value);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }

        // step 2 now set the random pointer for the new list
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next; //because we have created a copy of existing node in between
            }
            current = current.next.next;
        }

        // step 3 Now extract the existing and copied nodes
        current = head;
        Node newHead = head.next;
        Node copyCurrent = newHead;

        while (current != null) {
            current.next = current.next.next;
            assert copyCurrent != null;
            if (copyCurrent.next != null) {
                copyCurrent.next = copyCurrent.next.next;
            }
            current = current.next;
            copyCurrent = copyCurrent.next;
        }
        return newHead;
    }


}
