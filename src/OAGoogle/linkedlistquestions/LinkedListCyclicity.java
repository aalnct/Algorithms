package OAGoogle.linkedlistquestions;

class LinkedListCycleNode {
    int value;
    LinkedListCycleNode next;

    public LinkedListCycleNode (int value) {
        this.value = value;
    }
}
public class LinkedListCyclicity {

    public static void main(String[] args) {
        LinkedListCycleNode head = new LinkedListCycleNode(1);
        LinkedListCycleNode head2 = new LinkedListCycleNode(2);
        LinkedListCycleNode head3 = new LinkedListCycleNode(3);
        LinkedListCycleNode head4 = new LinkedListCycleNode(4);

        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head2; // create a cycle here

        System.out.println(hasCycle(head));
    }

    private static boolean hasCycle (LinkedListCycleNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        LinkedListCycleNode slow = head;
        LinkedListCycleNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}