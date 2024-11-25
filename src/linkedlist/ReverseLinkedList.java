package linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        System.out.println("After Reverse");
        ListNode reverse = reverseLinkedList(node);

        while(reverse != null) {
            System.out.print(reverse.data + " ");
            reverse = reverse.next;
        }
    }

    private static ListNode reverseLinkedList(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        ListNode next;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
