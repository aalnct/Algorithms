package restart.linkedlist.medium;

import ds.leetcode.linkedlist.ListNode;

public class RemoveNthNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;

        ListNode current  = removeNthNodeFromEnd(head,n);

        while (current != null) {
            System.out.println(current.data + "--");
            current = current.next;
        }
    }

    private static ListNode removeNthNodeFromEnd (ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;
        ListNode second = head;


        // we will move the first pointer till it reaches null
        for (int i=0; i < n+1; i++) {
            first = first.next;
        }

        // now we will move both first and second pointers
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // here we will remove the nth node
        second.next = second.next.next;

        return dummy.next;
    }
}
