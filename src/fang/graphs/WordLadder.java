package fang.graphs;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";

        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(ladderLength(beginWord,endWord,wordList));
    }

    static int ladderLength (String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList); // so that look up can be O(1)

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String > visited = new HashSet<>(); // making sure we are not processing duplicate words

        queue.offer(beginWord);
        visited.add(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i=0; i < size; i++) {
                String currWord = queue.poll();

                assert currWord != null;
                if (currWord.equals(endWord)) {
                    return level;
                }

                // transformation of words will happen in this for loop
                for (int j=0; j < currWord.length(); j++) {
                    char [] wordChar = currWord.toCharArray();

                    for (char c = 'a' ; c <= 'z'; c++) {
                        if (wordChar[j] == c) {
                            continue;
                        }

                        wordChar[j] = c; // substitute here

                        String newWord = new String(wordChar);

                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
