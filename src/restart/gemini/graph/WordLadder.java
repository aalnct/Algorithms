package restart.gemini.graph;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        System.out.println(wordLadder(beginWord,endWord,wordList));
    }

    static int wordLadder (String beginWord, String endWord, List<String> wordList) {
        int level = 1;
        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // means we will iterate all the words found at this level
            for (int i=0; i < levelSize; i++) {
                String word = queue.poll();

                for (int j=0; j < word.length(); j++) {
                    char [] wordChar = word.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {

                        if (wordChar[j] == c) {
                            continue;
                        }

                        wordChar[j] = c;

                        String transformedWord = new String(wordChar);
                        if (transformedWord.equals(endWord)) {
                            return level+1;
                        }

                        if (set.contains(transformedWord) && !visited.contains(transformedWord)) {
                            queue.offer(transformedWord);
                            visited.add(transformedWord);
                        }
                    }
                }
            }
            level = level+1;
        }
        return 0;
    }
}
