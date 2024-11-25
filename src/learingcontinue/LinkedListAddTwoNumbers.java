package learingcontinue;


class LinkedList {
    int value;
    LinkedList next;

    LinkedList (int value) {
        this.value = value;
    }
}
public class LinkedListAddTwoNumbers {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(2);
        list1.next = new LinkedList(4);
        list1.next.next = new LinkedList(3);

        LinkedList list2 = new LinkedList(5);
        list2.next = new LinkedList(6);
        list2.next.next = new LinkedList(4);

        LinkedList list = addTwoNumber(list1, list2);
        while (list != null) {
            System.out.println(list.value);
            list = list.next;
        }

    }



    public static LinkedList addTwoNumber (LinkedList list1, LinkedList list2) {
        LinkedList dummy = new LinkedList(0);
        LinkedList current = dummy;
        int carry = 0;
        LinkedList p = list1;
        LinkedList q = list2;

        while (p !=null || q != null) {
            int x = (p != null ) ? p.value : 0;
            int y = (q != null) ? q.value : 0;

            int sum = carry + x + y;
            carry = sum/10;
            current.next = new LinkedList(sum%10);
            current = current.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0) {
            current.next = new LinkedList(carry);
        }

        return dummy.next;
    }


}
