package fb;

public class RotationalCipher {

    public static void main(String[] args) {
        splitString("All-convoYs-9-be:Alert1.", 4);
    }


    private static void splitString (String string, int rotationFactor) {
        StringBuilder result = new StringBuilder();
        int originalPosition = 0;
        int newNumberPosition = 0;
        int newAphaPosition = 0;

        for (char character : string.toCharArray()) {
            boolean b = !Character.isAlphabetic(character) && !Character.isDigit(character);
            if (character != ' ' && Character.isAlphabetic(character)) {
                /**
                 * need to handle special case scenario -> character case
                 */

                if (character >= 'A' && character <= 'Z') {
                    originalPosition = character - 'A';
                    newAphaPosition = (originalPosition + rotationFactor) % 26;
                    Character newCharacter = (char) ('A' + newAphaPosition);
                    result.append(newCharacter);
                } else if (character >= 'a' && character <= 'z') {
                    originalPosition = character - 'a';
                    newAphaPosition = (originalPosition + rotationFactor) % 26;
                    Character newCharacter = (char) ('a' + newAphaPosition);
                    result.append(newCharacter);
                }
            } else if (character != ' ' && Character.isDigit(character)) {
                originalPosition = character - '0';
                newNumberPosition = (originalPosition + rotationFactor) % 10;
                char newCharacter = (char) ('0' + newNumberPosition);
                result.append(newCharacter);
            } else if (character == ' ' || b) {
                result.append(character);
            }
        }
            System.out.println("final Result :" + result);
    }
}
