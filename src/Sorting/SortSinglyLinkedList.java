package Sorting;


class ListNode {
    int value;
    ListNode next;

    ListNode () {

    }
    ListNode (int value) {
        this.value = value;
    }

    ListNode (int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

}
public class SortSinglyLinkedList {

    ListNode node;

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next= new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);
        ListNode data = insertionSortList(node);
        System.out.println(data);
        // System.out.println(insertionSortList(node));
    }

    public static ListNode insertionSortList (ListNode head) {
        ListNode temp = head;
        while (temp.next != null) {
            // System.out.println(temp.value);
            if (temp.value > temp.next.value) {
                int nodeValue = temp.value;
                temp.value = temp.next.value;
                temp.next.value= nodeValue;
            }
            temp = temp.next;

        }
        return temp;
    }

    public static ListNode insertionSortList_(ListNode head) {
        ListNode dummy = new ListNode(0); // use to keep track of beginning of sorted list
        ListNode current = head; // will be used to iterate through unsorted list
        ListNode prev = dummy;

        while (current != null) {
            ListNode next = current.next;

            // find the insertion point for the current node
            while (prev.next != null && prev.next.value <= current.value) {
                prev = prev.next;
            }

            current.next = prev.next;
            prev.next = current;

            current = next;
        }

        return dummy.next;
    }

}
