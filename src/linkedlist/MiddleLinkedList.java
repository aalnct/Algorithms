package linkedlist;

public class MiddleLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode list = findMiddleNode(node);
        while(list !=null) {
            System.out.print(list.data + " ");
            list = list.next;
        }

    }

    private static ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next; // by the time fast counter reaches end, slow will be at middle
        }

        return slow;
    }
}
