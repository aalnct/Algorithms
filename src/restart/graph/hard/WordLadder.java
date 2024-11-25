package restart.graph.hard;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        String beginWord1 = "hit";
        String endWord1 = "cog";
        List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        System.out.println(checkLevelLength(beginWord1,endWord1, wordList1));
    }

    private static int checkLevelLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1; // start level is 1 (being word level)

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i=0; i < levelSize; i++) {
                String currentWord = queue.poll();
                for (int j = 0; j < Objects.requireNonNull(currentWord).length(); j++) {
                    // convert to char array since String is immutable
                    char [] wordChars = currentWord.toCharArray();

                    for (char c = 'a'; c <='z'; c++) {
                        if (wordChars[j] == c) {
                            continue; // since it is a same letter , we can move to next letter
                        }
                        wordChars[j] = c;
                        String transformedWord = new String(wordChars);
                        if (transformedWord.equals(endWord)) {
                            return level + 1;
                        }

                        if (wordSet.contains(transformedWord) && !visited.contains(transformedWord)) {
                            visited.add(transformedWord);
                            queue.offer(transformedWord);
                        }
                    }
                }
            }
            level++;
        }

        return 0;
    }

}
