package leetcode.top_150;

public class RemoveDuplicateFromList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);

        ListNode removed = removeDuplicate(head);
        while (removed != null) {
            System.out.print(removed.value + " ");
            removed = removed.next;
        }
    }

    private static ListNode removeDuplicate(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null) {
            boolean isDuplicate = false;

            while (head.next != null &&
            head.value == head.next.value) {
                head = head.next;
                isDuplicate = true;
            }

            if (isDuplicate) {
                prev.next = head.next; // this will remove all occurance of duplicate elements
            } else {
                prev = prev.next;
            }

            head = head
                    .next;
        }
        return dummy.next;
    }

}
