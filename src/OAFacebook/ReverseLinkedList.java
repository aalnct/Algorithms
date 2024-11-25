package OAFacebook;


import ds.leetcode.linkedlist.ListNode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);

        ListNode result = reverseLinkedList(listNode);

        while (result != null) {
            System.out.print(result.data + "-->");
            result = result.next;
        }
        System.out.println(" null");
    }

    static ListNode reverseLinkedList (ListNode head) {
        ListNode current = head; // starting from the first node ...
        ListNode previous = null;
        ListNode next = null;

        while (current != null) { // 1
            next = current.next; // 2
            current.next = previous; // null
            previous = current; // 1
            current = next; // 2
        }

        return previous;

    }
}
