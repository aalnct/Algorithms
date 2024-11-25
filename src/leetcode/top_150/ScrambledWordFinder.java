package leetcode.top_150;

import java.util.HashSet;
import java.util.Set;

public class ScrambledWordFinder {

    public static void main(String[] args) {
        String [] words = {"baby", "referee", "cat", "dada", "dog", "bird", "ax", "baz"};
        String note = "ctay";
        System.out.println(find(words,note));
    }

    public static String find(String [] words, String note) {
        Set<Character> noteChars = new HashSet<>();
        for (char c : note.toCharArray()) {
            noteChars.add(c);
        }

        for (String word : words) {
            if (isScrambled(word,noteChars)) {
                return word;
            }
        }
        return "-";
    }

    private static boolean isScrambled(String word, Set<Character> noteChars) {
        Set<Character> wordCharacters = new HashSet<>();
        for(char c : word.toCharArray()) {
            wordCharacters.add(c);
        }
        return noteChars.containsAll(wordCharacters)
                && word.length() <= noteChars.size();
    }
}
