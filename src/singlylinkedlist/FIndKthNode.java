package singlylinkedlist;

class ListNodeK {
    int value;
    ListNodeK next;

    public ListNodeK(int value) {
        this.value = value;
        this.next = null;
    }
}
public class FIndKthNode {

    public static void main(String[] args) {
        ListNodeK head = new ListNodeK(1);
        head.next = new ListNodeK(2);
        head.next.next = new ListNodeK(3);
        head.next.next.next = new ListNodeK(4);
        head.next.next.next.next =  new ListNodeK(5);

        ListNodeK result = returnKthNode(head,2);
        System.out.println(result.value);
    }

    static ListNodeK returnKthNode (ListNodeK head, int k) {
        ListNodeK slow = head;
        ListNodeK fast = head;

        // move the fast pointer k nodes ahead...
        for (int i=0; i < k; i++) {

            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        // move both fast and slow pointer until fast reaches the end ...
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        return slow;
    }
}
