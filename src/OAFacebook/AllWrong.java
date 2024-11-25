package OAFacebook;

public class AllWrong {

    public static void main(String[] args) {
        System.out.println(allWrong(3,"ABA"));
    }

    static String allWrong(int n, String str) {
        String result = new String();
        char[] c = str.toCharArray();
        for (int i=0; i < n; i++) {
            if (c[i] == 'A') {
                result = result.concat(String.valueOf('B'));
            } else if (c[i] == 'B') {
                result = result.concat(String.valueOf('A'));
            }
        }

        return result;
    }
}
