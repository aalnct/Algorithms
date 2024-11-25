package OAGoogle.linkedlistquestions;


class ReverseListNode {

    int value;
    ReverseListNode next;

    public ReverseListNode (int value) {
        this.value = value;
    }

}
public class ReverseSubList {

    public static void main(String[] args) {
        ReverseListNode head = new ReverseListNode(1);
        head.next = new ReverseListNode(2);
        head.next.next = new ReverseListNode(3);
        head.next.next.next = new ReverseListNode(4);
        head.next.next.next.next = new ReverseListNode(5);
        int start = 2;
        int end = 4;
        ReverseListNode reverseListNode = reverseSubList(head,start,end);

        while (reverseListNode != null) {
            ReverseListNode next = reverseListNode;
            System.out.println(next.value);
            reverseListNode = reverseListNode.next;
        }
    }

    private static ReverseListNode reverseSubList(ReverseListNode head, int start, int end) {
        if (head == null || start >= end) {
            return head;
        }

        ReverseListNode dummy = new ReverseListNode(0);
        dummy.next = head;
        ReverseListNode previousStart = dummy;

        for (int i=0; i< start; i++) {
            previousStart = previousStart.next;
        }

        ReverseListNode startNode = previousStart.next; // this will be start node in first iteration
        ReverseListNode current = startNode; // set current to start node
        ReverseListNode prev = null; // set prev to null

        for (int i=start; i <= end; i++) { // starting from start node
            ReverseListNode nextNode = current.next; // this will next node of start node in first iteration
            current.next = prev; // setting the next node from start to null
            prev = current; // prev becomes starting point ....
            current = nextNode; // current becomes next node now which we will update next
        }

        previousStart.next = prev;
        startNode.next = current;

        return dummy.next;
    }

}
