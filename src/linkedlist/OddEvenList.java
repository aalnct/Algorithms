package linkedlist;

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
    }
}
public class OddEvenList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        printList(head);

        System.out.println("After re arrange");
        ListNode reorder = oddEvenList(head);

        printList(reorder);
    }

    private static ListNode oddEvenList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode odd = node;
        ListNode even = node.next;
        ListNode evenHead = even;

        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return node;
    }

    private static void printList(ListNode head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
