package leetcode.stringmanipulation;

public class Encryption {
    public static void main(String[] args) {
        String original = "have a nice day";
        System.out.println(original);

        String encrypted = encryptString(original);
        System.out.println(" Encrypted :" + encrypted);
    }

    private static String encryptString(String text) {
        String textWithOutSpaces = text.replaceAll("\\s", "");

        int length = textWithOutSpaces.length();
        int rows = (int)Math.floor(Math.sqrt(length));
        int cols = (int)Math.ceil(Math.sqrt(length));

        if(rows * cols < length) {
            rows++;
        }

        StringBuilder encryptedText = new StringBuilder();
        for(int col = 0; col < cols; col++) {
            for(int row = 0; row < rows; row++) {
                int index = col + row * cols;

                if(index < length) {
                    encryptedText.append(textWithOutSpaces.charAt(index));
                }
            }
            encryptedText.append(' ');
        }
        return encryptedText.toString().trim();
    }
}
