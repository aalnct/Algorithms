package leetcode.top_150;

public class MergeList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(6);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(7);

        ListNode merged = mergedList(l1,l2);

        while (merged != null) {
            System.out.print(merged.value + " --> ");
            merged = merged.next;
        }
    }

    private static ListNode mergedList (ListNode l1, ListNode l2) {
        ListNode prevNode = new ListNode(-1);
        ListNode prev = prevNode;

        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }

            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;

        return prevNode.next;
    }
}
