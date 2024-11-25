package OAFacebook;

class LinkedList {
    int data;
    LinkedList next;

    public LinkedList (int data) {
        this.data = data;
        this.next = null;
    }
}
public class MergeTwoList {

    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList(1);
        linkedList1.next = new LinkedList(2);
        linkedList1.next.next = new LinkedList(10);
        linkedList1.next.next.next = new LinkedList(20);

        LinkedList linkedList2 =  new LinkedList(0);
        linkedList2.next = new LinkedList(3);
        linkedList2.next.next = new LinkedList(8);

        LinkedList result = mergeTwoList(linkedList1,linkedList2);

        while (result != null) {
            System.out.println(result.data);
            result = result.next;
        }
    }

    static LinkedList mergeTwoList(LinkedList list1, LinkedList list2) {
        LinkedList prevNode = new LinkedList(-1);
        LinkedList prev = prevNode;

        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }

            prev = prev.next;
        }

        prev.next = list1 != null ?list1 : list2;

        return prevNode.next;
    }
}
