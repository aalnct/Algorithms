package OAGoogle.linkedlistquestions;

class LinkedListCycleNode2 {
    public int value;
    public LinkedListCycleNode2 next;

    public LinkedListCycleNode2 (int value) {
        this.value = value;
    }
}
public class LinkedListCycle2 {

    public static void main(String[] args) {
        LinkedListCycleNode2 head = new LinkedListCycleNode2(3);
        LinkedListCycleNode2 head2 = new LinkedListCycleNode2(2);
        LinkedListCycleNode2 node0 = new LinkedListCycleNode2(0);
        LinkedListCycleNode2 node4 = new LinkedListCycleNode2(4);

        head.next = head2;
        head2.next = node0;
        node0.next = node4;
        node4.next = head2;

        LinkedListCycleNode2 startingPoint = getCycle(head);

        if (startingPoint != null) {
            System.out.println("Starting node of the cycle ... " + startingPoint.value);
        } else {
            System.out.println("there is no cycle .... ");
        }
    }

    private static LinkedListCycleNode2 getCycle (LinkedListCycleNode2 head) {
        // using Floyd's cycle finding algorithm

        if (head  == null || head.next == null) {
            return null; // no cycle
        }

        LinkedListCycleNode2 slow = head;
        LinkedListCycleNode2 fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast  = fast.next.next; // taking 2 steps at a time

            if (slow == fast) { // means there is a cycle, so lets reset slow back
                slow = head;

                if (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }
        return null;
    }
}
