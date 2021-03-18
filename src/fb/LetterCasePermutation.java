package fb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LetterCasePermutation {

    public static void main(String[] args) {
        String string = "a1b2";
        List<String> result = letterCasePermutation(string);
        result.stream().forEach(s -> System.out.println());
    }

    static List<String> letterCasePermutation (String string) {
        List<String> result = new ArrayList<>();
        if (string.length() <= 0) {
            return null;
        }

        helper(new char[string.length()], result,0,string);

        return new ArrayList<>(result);
    }

    private static void helper(char[] chars, List<String> result, int position, String string) {
        if (position == chars.length) {
            result.add(new String(chars));
            return;
        }

        if (Character.isDigit(chars[position])) {
            helper(chars,result,position+1,string);
        }

        chars[position] = Character.toUpperCase(string.charAt(position));
        helper(chars,result,position+1,string);

        chars[position] = Character.toLowerCase(string.charAt(position));
        helper(chars,result,position+1,string);
    }


}
