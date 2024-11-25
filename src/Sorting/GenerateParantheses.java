package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParantheses {

    public static void main(String[] args) {
        generateParantheses(3).forEach(System.out::println);
    }

    private static List<String> generateParantheses(int n) {
        List<String> generate = new ArrayList<>();
        generateParanthesesHelper("", 0, 0, n, generate);
        return generate;
    }

    private static void generateParanthesesHelper(String current, int openCount, int closingCount, int n, List<String> result) {
        if (openCount == n && closingCount == n) {
            result.add(current);
        }

        if (openCount < n) {
            generateParanthesesHelper(current + "(", openCount+1, closingCount, n, result);
        }

        if (closingCount < openCount) {
            generateParanthesesHelper(current+")", openCount, closingCount+1, n, result);
        }
    }
}
