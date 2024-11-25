package restart.linkedlist.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergedSortedList {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8);

        mergedSortedList(list1,list2).forEach(System.out::print);

    }

    static List<Integer> mergedSortedList (List<Integer> list1, List<Integer> list2) {
        List<Integer> merged = new ArrayList<>();

        int i = 0; int j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                merged.add(list1.get(i));
                i++;
            } else {
                merged.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            merged.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            merged.add(list2.get(j));
            j++;
        }
        return merged;
    }
}
