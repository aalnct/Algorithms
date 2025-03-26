package restart.graph.medium;

public class FindMinimumDistanceBetweenWords3 {

    public static void main(String[] args) {
        String [] words = {"a","a","b","b"};
        String word1 = "a";
        String word2 = "b";

        System.out.println(findMinimumDistance(words,word1, word2));
    }

    static int findMinimumDistance (String [] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int minimumDistance = Integer.MAX_VALUE;

        boolean isSame = word1.equals(word2);

        for (int i=0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (isSame) {
                    index2 = index1;
                }
                index1 = i; // 1 // 4
            } else if (words[i].equals(word2)) {
                index2 = i; // 3
            }
            if (index1 != -1 && index2 != -1) {
                minimumDistance = Math.min(minimumDistance, Math.abs(index1 - index2));
            }
        }
        return minimumDistance;
    }
}
