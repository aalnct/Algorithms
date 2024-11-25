package linkedlist;

public class MergeBetweenZeros {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(0);

        ListNode node = mergeBetweenNodes(listNode);

        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    private static ListNode mergeBetweenNodes(ListNode node) {
        ListNode dummy = new ListNode(0);
        dummy.next = node;
        ListNode current = dummy;

        while(current != null && current.next != null) {
            if (current.data == 0 && current.next.data == 0) {
                current = merge(current);
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }

    private static ListNode merge(ListNode start) {
        ListNode end = start.next;

        while(end != null && end.data != 0 ) {
            end = end.next;
        }
        int sum = 0;
        ListNode current = start.next;

        while(current != end) {
            sum += current.data;
            current = current.next;
        }

        start.next = new ListNode(sum);
        start.next.next = end;

        return start;
    }
}
