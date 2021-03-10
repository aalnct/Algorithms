package fb;

public class TwoStringArrays {

    public static void main(String[] args) {
        String[] word1 = {"abc", "d","efg"};
        String[] word2 = {"abcddefg"};
        System.out.println(arrayStringsEqual(word1,word2));
    }

    static boolean arrayStringsEqual(String[] word1, String[] word2) {
        boolean flag = false;
        String s1 = "";
        String s2 = "";
        for (int i=0;i<word1.length;i++) {
            s1 = s1.concat(word1[i]);
        }
        for (int i=0;i<word2.length;i++) {
            s2 = s2.concat(word2[i]);
        }
        if (s1.equalsIgnoreCase(s2)) {
            flag = true;
        }

        return flag;
    }
}
