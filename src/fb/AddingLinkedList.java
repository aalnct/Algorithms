package fb;

import java.util.LinkedList;
import java.util.List;

public class AddingLinkedList {

    public static void main(String[] args) {

        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();

        list1.add(2);
        list1.add(4);
        list1.add(3);

        list2.add(5);
        list2.add(6);
        list2.add(4);

        int result = addLinkedList(list1,list2);
        System.out.println(result);
    }

    static int addLinkedList (List<Integer> list1, List<Integer> list2) {
        String s1 = "";
        String s2 = "";
        if (list1.size() >0) {
            for (int i = 0; i < list1.size();i++) {
                s1 = s1.concat(String.valueOf(list1.get(i)));
            }
        }

        if (list2.size() >0) {
            for (int i = 0; i < list2.size();i++) {
                s2 = s2.concat(String.valueOf(list2.get(i)));
            }
        }

        int finalResult = Integer.valueOf(s1) + Integer.valueOf(s2);

        return finalResult;
    }
}
