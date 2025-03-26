package restart.graph.easy;

public class FindMinimumDistanceBetweenWords1 {

    public static void main(String[] args) {
        String [] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";

        System.out.println(findMinimumDistance(words,word1, word2));
    }

    static int findMinimumDistance (String [] words, String word1, String word2) {
        int index1  = -1;
        int index2 = -1;
        int minimumDistance = Integer.MAX_VALUE;

        for (int i= 0 ; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
                if (index2 != -1) {
                    minimumDistance = Math.min(minimumDistance, Math.abs(index1 - index2));
                }
            } else if (words[i].equals(word2)) {
                index2 = i;
                if (index1 != -1) {
                    minimumDistance = Math.min(minimumDistance, Math.abs(index1 - index2));
                }
            }
        }
        return minimumDistance;
    }
}
