package leetcode.top_150;

class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }
}
public class LinkedListHasCycle {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);

        System.out.println(hasCycle(listNode));
    }

    private static boolean hasCycle (ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
