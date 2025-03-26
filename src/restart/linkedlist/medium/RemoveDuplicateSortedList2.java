package restart.linkedlist.medium;

public class RemoveDuplicateSortedList2 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(5);

        ListNode value = removeDuplicate(listNode);
        while (value != null) {
            System.out.println(value.value);
            value = value.next;
        }

    }

    static ListNode removeDuplicate (ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null) {
            if (head.next != null && head.value == head.next.value) {
                while (head.next != null && head.value == head.next.value) {
                    head = head.next; // keep skipping till there are duplicates
                }
                prev.next = head.next; // prev next pointer will point to head next value, since we are skippng all elements that are
                                        // duplicate
            } else {
                prev = prev.next; // just point previous to next node
            }
            head = head.next;
        }
        return dummy.next;
    }
}
