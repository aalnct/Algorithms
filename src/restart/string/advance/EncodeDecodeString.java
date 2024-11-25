package restart.string.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeString {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("hello", "world", "encode", "decode", "123");
        String encoded = encodeString(stringList);

        System.out.println("Encoded String ::" + encoded);

        List<String> decoded = decodeString(encoded);

        System.out.println("Decoded String :: " + decoded);
    }

    static String encodeString (List<String> strs) {
        StringBuilder encode = new StringBuilder();

        for (String str : strs) {
            encode.append(str.length()).append("#").append(str);
        }

        return encode.toString();
    }

    static List<String> decodeString (String strs) {
        List<String> decoded = new ArrayList<>();
        int i=0;

        while (i < strs.length()) {
            // first we have to find the delimiter
            int delimiterIndex = strs.indexOf("#",i); // i is from index

            // find the length of next string
            int length = Integer.parseInt(strs.substring(i,delimiterIndex));
            //then extract String of given length
            i = delimiterIndex + 1 + length;
            decoded.add(strs.substring(delimiterIndex+1,i));
        }

        return decoded;
    }
}
