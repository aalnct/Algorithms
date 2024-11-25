package leetcode.top_150;

public class RotateList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        ListNode rotated = rotateList(head,k);

        while (rotated != null) {
            System.out.print(rotated.value + " ");
            rotated = rotated.next;
        }
    }

    private static ListNode rotateList(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;

        if (k == 0) {
            return head;
        }

        ListNode newTail = head;

        for (int i=0; i < length - k -1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        // connecting the original list to new list ...
        tail.next = head;

        return newHead;
    }
}
