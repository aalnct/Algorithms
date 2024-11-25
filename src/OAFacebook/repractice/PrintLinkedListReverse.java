package OAFacebook.repractice;



public class PrintLinkedListReverse {

    public static void main(String[] args) {
        SinglyLinkedList head = new SinglyLinkedList(1);
        head.next = new SinglyLinkedList(2);
        head.next.next = new SinglyLinkedList(3);
        head.next.next.next = new SinglyLinkedList(4);

        SinglyLinkedList result = reversePrint(head);
        while (result != null) {
            System.out.println(result.data);
            result = result.next;
        }
    }

    static SinglyLinkedList reversePrint (SinglyLinkedList head) {
        SinglyLinkedList current = head;
        SinglyLinkedList previous = null;
        SinglyLinkedList next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
