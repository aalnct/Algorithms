package fb;

public class StringCompression {

    public static void main(String[] args) {
        System.out.println(stringCompression("aabcccccdaa"));
    }

    static String stringCompression(String string) {
        char[] ch = string.toCharArray();
        int j = 0;
        String newString = "";
        int counter = 1;

        for (int i=0; i< ch.length-1;i++) {
            j = i+1;
            if (ch[i] == ch[j]) {
                counter++;
            } else {
                newString = newString + ch[i] + counter;
                counter = 1;
            }
        }

        if (counter > 0) {
            newString = newString + ch[ch.length-1] + counter;
        }

        return newString;
    }
}
