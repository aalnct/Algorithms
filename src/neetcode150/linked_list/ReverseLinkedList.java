package neetcode150.linked_list;

class ListNode {
    int val;
    ListNode next;

    public ListNode (int val) {
        this.val = val;
    }
}
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode v = reverse(l1);

        while (v != null) {
            System.out.print(v.val + "-->");
            v = v.next;
        }
    }

    static ListNode reverse (ListNode listNode) {
        ListNode prev = null;
        ListNode current = listNode;

        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }
}
