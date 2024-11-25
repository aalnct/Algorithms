package singlylinkedlist;


class ListNodeLength {
    int value;
    ListNodeLength next;

    public ListNodeLength (int value) {
        this.value = value;
        this.next = null;
    }
}
public class SinglyLinkedListLength {

    public static void main(String[] args) {
        ListNodeLength head = new ListNodeLength(1);
        head.next = new ListNodeLength(2);
        head.next.next = new ListNodeLength(3);

        System.out.println(findLength(head));
    }

    static int findLength (ListNodeLength head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
