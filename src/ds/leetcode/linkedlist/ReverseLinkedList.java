package ds.leetcode.linkedlist;

/**
 * Created by AmitAgarwal on 5/31/20.
 */
public class ReverseLinkedList {

    public ListNode reverseLinkedList(ListNode head){
        ListNode current = head;
        ListNode previous = null;
        ListNode next;

        while(current!=null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    public void printLinkedList(ListNode node){
        while(node!=null){
            System.out.println(node.data + "-->");
            node = node.next;
        }
    }

}
