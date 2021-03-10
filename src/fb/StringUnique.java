package fb;

public class StringUnique {

    public static void main(String[] args) {
        System.out.println(isUnique("abbd"));
    }

    static boolean isUnique(String string) {
        int uniqueCounter = 0;
        char[] ch = string.toCharArray();
        for (int i=0; i< ch.length-1;i++) {
            if (ch[i] == ch[i+1]) {
                uniqueCounter++;
            }
        }

        return uniqueCounter == 0;
    }
}
