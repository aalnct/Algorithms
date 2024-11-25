package OAFacebook.repractice;

public class DeleteDuplicateLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList head = new SinglyLinkedList(1);
        head.next = new SinglyLinkedList(2);
        head.next.next = new SinglyLinkedList(2);
        head.next.next.next = new SinglyLinkedList(3);
        head.next.next.next.next = new SinglyLinkedList(4);

        SinglyLinkedList result = deleteDuplicate(head);

        while (result != null) {
            System.out.println(result.data);
            result = result.next;
        }

    }

    static SinglyLinkedList deleteDuplicate (SinglyLinkedList head) {
        if (head == null) {
            return null;
        }

        SinglyLinkedList slow = head;
        SinglyLinkedList fast = head.next;


        while (fast != null) {
            if (slow.data == fast.data) {
                slow.next = fast.next;
            } else {
                slow = fast;
            }
            fast = fast.next;
        }
        return head;
    }
}
