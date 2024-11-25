package OAFacebook;

public class AddTwoList {

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList(1);
        l1.next = new LinkedList(2);
        l1.next.next = new LinkedList(3);
        l1.next.next.next = new LinkedList(9);


        LinkedList l2 = new LinkedList(4);
        l2.next = new LinkedList(5);
        l2.next.next = new LinkedList(6);

        LinkedList result = addTwoList(l1,l2);

        printList(result);
    }

    static void printList (LinkedList head) {
        LinkedList current = head;
        while (current != null) {
            System.out.println(current.data + " -> ");
            current = current.next;
        }
    }

    static LinkedList addTwoList(LinkedList l1, LinkedList l2) {
        LinkedList dummy = new LinkedList(0);
        LinkedList current = dummy;
        int carry = 0;

        while (l1 != null ||  l2 != null) {
            int x = (l1 != null) ? l1.data : 0;
            int y = (l2 != null) ? l2.data : 0;

            int sum = x + y + carry;

            // if there is a carry
            carry = sum/10;
            current.next = new LinkedList(sum %10);

            // move to next if available
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            current = current.next;
        }
        // this is last carry
        if (carry > 0) {
            current.next = new LinkedList(carry);
        }
        return dummy.next;
    }
}
