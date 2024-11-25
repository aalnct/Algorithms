package OAGoogle.linkedlistquestions;


class SinglyListNode {
    int value;
    SinglyListNode next;

    public SinglyListNode (int value) {
        this.value = value;
    }
}
public class ReverseSinglyLinkedList {

    public static void main(String[] args) {
        SinglyListNode head = new SinglyListNode(1);
        head.next = new SinglyListNode(2);
        head.next.next = new SinglyListNode(3);
        head.next.next.next = new SinglyListNode(4);

        SinglyListNode node = reverseListNode(head);

        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }


    static SinglyListNode reverseListNode(SinglyListNode head) {
        SinglyListNode current = head;
        SinglyListNode previous = null;

        while (current != null) {
            SinglyListNode nextNode = current.next; // save the next node
            current.next = previous; // change the next pointer to previous node ...

            // move previous and current position one step forward
            previous = current;
            current = nextNode;
        }
        return previous;
    }

}
