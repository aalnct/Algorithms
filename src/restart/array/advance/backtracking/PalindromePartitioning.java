package restart.array.advance.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        List<List<String>> result = partition("aab");

        for (List<String> stringList : result) {
            for (String s : stringList) {
                System.out.print (s + " ");
            }
        }
    }

    static List<List<String>> partition (String string) {
        List<List<String>> result = new ArrayList<>();
        backTrack(string,0, new ArrayList<>(), result);
        return result;
    }

    static void backTrack (String string, int start, List<String> current, List<List<String>> result) {
        if (start == string.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < string.length(); end ++) {
            if (isPalindrome(string,start,end)) {
                current.add(string.substring(start,end+1));
                backTrack(string,start+1,current,result); //a a b aa b // a a b aa a b
                current.remove(current.size()-1);
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
