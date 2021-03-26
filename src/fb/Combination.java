package fb;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    public static void main(String[] args) {
        List<List<Integer>> result = combine(4,2);
        result.forEach(System.out::println);
    }

    static List<List<Integer>> combine (int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtracking (result,current,1,n,k);

        return result;
    }

    static void backtracking (List<List<Integer>> result, List<Integer> current,
                               int start, int end, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(current));
        }

        for (int i = start; i<= end; i++) {
            current.add(i);
            backtracking(result,current,i+1,end,k-1);
            current.remove(current.size()-1);
        }
    }


}
