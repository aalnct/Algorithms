package leetcode.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ZigZagIterator {

    private static Iterator<Integer> iter1;
    private static Iterator<Integer> iter2;

    private static boolean isFirst = true;

    public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
        iter1 = v1.listIterator();
        iter2 = v2.listIterator();
        isFirst = v1.size() > 0;
    }

    public static int next() {
        if (isFirst && iter1.hasNext() || !iter2.hasNext()) {
            isFirst = !isFirst;
            return iter1.next();
        } else {
            isFirst = !isFirst;
            return iter2.next();
        }
    }

    public static boolean hasNext() {
        return iter1.hasNext() || iter2.hasNext();
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2);
        List<Integer> list2 = Arrays.asList(3,4,5);

        ZigZagIterator zigZagIterator = new ZigZagIterator(list1,list2);
        while (hasNext()) {
            System.out.println(next() + " ");
        }
    }
}
