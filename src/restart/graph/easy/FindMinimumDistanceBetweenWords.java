package restart.graph.easy;

public class FindMinimumDistanceBetweenWords {

    public static void main(String[] args) {
        String text = "the quick brown fox jumps over the lazy dog";
        String word1 = "fox";
        String word2 = "dog";

        System.out.println(findMinimumDistance(text,word1,word2));
    }

    static int findMinimumDistance (String text, String word1, String word2) {

        int index1 = -1;
        int index2 = -1;
        int minimumDistance = Integer.MAX_VALUE;

        // need to convert entire String sentence into array
        // so that we can calculate distance b/w words easily
        String [] words = text.split(" ");
        for (int i=0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
                if (index2 != -1) {
                    minimumDistance = Math.min(minimumDistance,
                            Math.abs(index2 - index1));
                }
            } else if (words[i].equals(word2)) {
                index2 = i;
                if (index1 != -1) {
                    minimumDistance = Math.min(minimumDistance,Math.abs(index1 - index2));
                }
            }
        }
        return minimumDistance;
    }
}
