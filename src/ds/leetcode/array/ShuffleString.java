package ds.leetcode.array;

public class ShuffleString {
    public static void main(String[] args) {

        String s  = shuffleString("codeleet", new int [] {4,5,6,7,0,2,1,3});
        System.out.println(s);
    }

    private static String shuffleString (String str, int [] indices) {
        char [] strArray = new char[indices.length];
        for (int i = 0; i < indices.length ; i++) {
            strArray[indices[i]] = str.charAt(i);
        }
        return String.valueOf(strArray);
    }
}
