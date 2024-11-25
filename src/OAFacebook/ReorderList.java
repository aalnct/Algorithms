package OAFacebook;


public class ReorderList {

    public static void main(String[] args) {
        LinkedList node = new LinkedList(1);
        node.next = new LinkedList(2);
        node.next.next = new LinkedList(3);
        node.next.next.next = new LinkedList(4);
        node.next.next.next.next = new LinkedList(5);

        LinkedList head = node;

        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }

        reorderList(node);

        System.out.println(" ");

        head = node;

        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println(" null ");
    }

    static void reorderList (LinkedList head) {
        if (head == null || head.next == null) {
            return;
        }

        //step 1 :  find the middle

        LinkedList slow = head;
        LinkedList fast = head;

        // slow will stop at the half of linked list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // step 2 : reverse the second half
        LinkedList prev = null;
        LinkedList current = slow; // so current is at the half of linked list
        LinkedList next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // step 3 : merge both
        LinkedList firstHalf = head; // that is start
        LinkedList secondHalf = prev; // that is last

        while (secondHalf.next != null) {
            next = firstHalf.next;
            firstHalf.next = secondHalf;
            firstHalf = next;

            next = secondHalf.next;
            secondHalf.next = firstHalf;
            secondHalf = next;
        }
    }
}
