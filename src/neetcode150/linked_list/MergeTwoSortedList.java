package neetcode150.linked_list;

public class MergeTwoSortedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);

        ListNode result = mergeTwoSortedList(l1,l2);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    static ListNode mergeTwoSortedList (ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // if any node left
        current.next = (l1 != null ) ? l1 : l2;

        return dummy.next;
    }
}
