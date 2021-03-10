package fb;

public class StringReplaceSpace {

    public static void main(String[] args) {
        replaceSpace("Mr John Smith");
    }

    static void replaceSpace(String string) {
        char[] chArray = new char[string.length()];
        if (string==null || string.length() <= 1) return;

        for (int i=0;i<string.length();i++) {
            Character ch = string.charAt(i);
            if (Character.isSpaceChar(ch)) {
                ch = string.replace(" ", "%20").charAt(i);
            }
            chArray[i] = ch;
        }

        for (int i = 0; i< chArray.length; i++) {
            System.out.print(chArray[i]);
        }
    }
}
