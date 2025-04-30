package neetcode150.linked_list;

public class DetectCycleList {

    public static void main(String[] args) {
        // Creating a linked list without a cycle
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
// This is a normal list: 1 -> 2 -> 3 -> null

// Creating a linked list with a cycle
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
// Create the cycle: make the last node point to the second node
        head2.next.next.next.next = head2.next;
// This creates a cycle: 1 -> 2 -> 3 -> 4 -> 2 (cycle)

        System.out.println(detectCycle(head1));


    }

    static boolean detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
