package leetcode.top_150;


/***
 *  incomplete solution
 */
public class ReverseLinkedList {
    public static void main(String[] args) {

    }

    private static ListNode reverseBetween (ListNode head, int left, int right) {
        if (head == null || left >= right) {
            return head;
        }

        ListNode dummy = new ListNode(0); // create a dummy node to simplify the code
        dummy.next = head;
        ListNode prev = dummy; // initialize the previous node before the reversal

        // move previous to the node just before the left node ...
        for (int i=0; i < left; i++) {
            prev = prev.next;
        }

        ListNode current = prev.next; // current node to be reversed
        ListNode tail = current; // tail node of the reverse sublist

        // reverse the sublist from left to right
        for (int i=left; i <= right; i++ ) {
            ListNode next = current.next;
        }

        return null;
    }
}
