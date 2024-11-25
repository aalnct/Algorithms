package restart.linkedlist.easy;

class ListNode {
    ListNode next;
    int value;

    public ListNode (int value) {
        this.value = value;
    }
}
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(8);
        node.next.next = new ListNode(15);
        node.next.next.next = new ListNode(22);

        ListNode result = reverseLinkedList(node);
        while (result != null) {
            System.out.print(result.value + " -> ");
            result = result.next;
        }
    }
    // 4- 8 - 15 - 22
    static ListNode reverseLinkedList (ListNode head) {
        ListNode prevNode = null;
        ListNode currNode = head; // 4

        while (currNode != null) {
            ListNode next = currNode.next; // next of 4 here is 8, so next is 8 now
            currNode.next = prevNode;
            prevNode = currNode; // which was pointing to null, now become 4
            currNode = next; // and after 4, it is now 8
        }
        return prevNode;
    }
}
