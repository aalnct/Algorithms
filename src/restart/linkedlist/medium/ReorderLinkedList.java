package restart.linkedlist.medium;

import ds.leetcode.linkedlist.ListNode;

public class ReorderLinkedList {

    public static void main(String[] args) {

    }

    static void reOrderLinkedList (ListNode head) {
        // there will be three steps
        // 1. Find the middle of list
        // 2. Reverse second half of linked list
        // 3. Merge both the list

        // Step 1 : find middle of list
        ListNode slow = head;
        ListNode fast = head;

        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow from above step is middle of linked list
        // step 2 : now reverse the second half
        ListNode prev = null;
        ListNode current = slow; // since slow pointer is the head of second half

        while (current != null) {
            // 4 8  | 15  16 23
            ListNode next = current.next; // current here is 15 // so current next is 16, so next is 16, 23, null
            current.next = prev; // so prev is null, so current next here became null, 15, 16
            prev = current; // so here prev became 15, since current here is 15, 16, 23
            current = next; // so next here is 16, so we move current to next node , so it became 16, 23, null
        }

        // now merge both list
        // step3 :  joining both list
        ListNode first = head;
        ListNode second =  prev; // prev is now the head of second linked list

        while (second.next != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;

        }

    }
}
