package fb;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        List<List<String>> result = partition("aab");
        result.forEach(System.out::println);
    }

    static List<List<String>> partition (String s) {
        List<List<String>> result = new ArrayList<>();
        dfs (0,result,new ArrayList<>(),s);
        return result;
    }

    static void dfs (int start, List<List<String>> result, List<String> current,
                     String s) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(current));
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome (s,start,end)) {
                current.add(s.substring(start,end+1));
                dfs(end+1,result,current,s);
                current.remove(current.size()-1);
            }
        }
    }

    static boolean isPalindrome (String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
