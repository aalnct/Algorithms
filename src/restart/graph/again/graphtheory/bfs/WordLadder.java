package restart.graph.again.graphtheory.bfs;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        String begin = "hit";
        String end = "cog";

        System.out.println(wordLadder(wordList,begin,end));
    }

    static int wordLadder (List<String> wordList, String begin, String end) {
        Set<String> set = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();

        if (!set.contains(end)) {
            return 0;
        }

        visited.add(begin);
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        int level = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i=0; i < levelSize; i++) {
                String current = queue.poll();
                for (int j = 0; j < current.length(); j++) {
                    char [] wordChar = current.toCharArray();
                    for (char c = 'a'; c<='z'; c++) {
                        if (wordChar[j] == c) {
                            continue;
                        }
                        wordChar[j] = c;

                        String transformWord = new String(wordChar);

                        if (transformWord.equals(end)) {
                            return level+1;
                        }

                        if (!visited.contains(transformWord) && set.contains(transformWord)) {
                            queue.offer(transformWord);
                            visited.add(transformWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
