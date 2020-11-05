package ds.leetcode.linkedlist;

import java.util.List;

/**
 * Created by AmitAgarwal on 5/7/20.
 */
public class ClientApp {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(104);
        ListNode l2 = new ListNode(205);
        ListNode ll = addTwoNumbers(l1,l2);

        ListNode listNode = new ListNode();
        listNode.current = new ListNode(85);
        listNode.current.next = new ListNode(15);
        listNode.current.next.next = new ListNode(4);
        listNode.current.next.next.next = new ListNode(14);

        System.out.println("Given Linked List");
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.printLinkedList(listNode.current);
        listNode.current = reverseLinkedList.reverseLinkedList(listNode.current);
        System.out.println( " " );
        System.out.println("Reverse");
        reverseLinkedList.printLinkedList(listNode.current);

        //System.out.println(ll.data);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int carry = 0;
        ListNode emptyNode = new ListNode(0);
        ListNode currentNode = new ListNode(0);
        ListNode result = currentNode;
        while(emptyNode!= l1 || emptyNode != l2){
            int sum = l1.data + l2.data + carry;
            carry = sum/10;
            currentNode = (currentNode.next = new ListNode(sum%=10));
            l1 = null !=l1.next? l1.next : emptyNode;
            l2 = null !=l2.next? l2.next : emptyNode;
        }
        if(carry == 1)
            currentNode.next = new ListNode(carry);
        return result.next;
    }

}
