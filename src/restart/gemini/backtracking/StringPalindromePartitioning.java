package restart.gemini.backtracking;

import java.util.ArrayList;
import java.util.List;

public class StringPalindromePartitioning {

    public static void main(String[] args) {
        String string = "aab";
        List<List<String>> result = palindromePartition(string);

        for (List<String> r : result) {
            for (String _r : r) {
                System.out.print(" " + _r + " ");
            }
        }
    }

    static List<List<String>> palindromePartition (String string) {
        List<List<String >> result = new ArrayList<>();
        backTrack (string,0,new ArrayList<>(), result);
        return result;
    }

    static void backTrack (String string, int start, List<String> currentPartition, List<List<String>> result) {
        if (start == string.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int end = start; end < string.length(); end++) {
            if (isPalindrome(string,start,end)) {
                currentPartition.add(string.substring(start,end+1));
                backTrack(string,end+1,currentPartition,result);
                currentPartition.remove(currentPartition.size()-1); // backtrack here , to explore other paths from current position
            }
        }
    }

    static boolean isPalindrome (String string, int start, int end) {
        while (start < end) {
            if (string.charAt(start) != string.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
