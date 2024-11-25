package OAGoogle.linkedlistquestions;

class DoublyListNode {
    int value;
    DoublyListNode next;
    DoublyListNode previous; // since its doubly, we also need to maintain pointers to prev node ...

    public DoublyListNode(int value) {
        this.value = value;
    }
}
public class MergeDoublySortedList {

    public static void main(String[] args) {
        DoublyListNode list1 = new DoublyListNode(1);
        list1.next = new DoublyListNode(4);
        list1.next.next = new DoublyListNode(5);

        DoublyListNode list2 = new DoublyListNode(2);
        list2.next = new DoublyListNode(3);
        list2.next.next = new DoublyListNode(6);

        DoublyListNode listNode = mergeDoublyListNode(list1, list2);

        while (listNode != null) {
            System.out.println(listNode.value);
            listNode = listNode.next;
        }
    }

    private static DoublyListNode mergeDoublyListNode(DoublyListNode list1,
                                                      DoublyListNode list2) {

        DoublyListNode dummy = new DoublyListNode(-1);
        DoublyListNode current = dummy;

        // merge the list here
        while (list1 != null && list2 != null) {
            if (list1.value <= list2.value) {
                current.next = list1;
                list1.previous = current;
                list1 = list1.next;
            } else {
                // move for list2
                current.next = list2;
                list2.previous = current;
                list2 = list2.next;
            }
            current = current.next; // keep moving to next node ...
        }
        // if any list remained ...

        if (list1 != null) {
            current.next = list1;
            list1.previous = current;
        } else {
            current.next = list2;
            list2.previous = current;
        }

        return dummy.next;
    }
}
