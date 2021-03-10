package fb;

import java.util.HashMap;
import java.util.Map;

public class DecodeString {

    public static void main(String[] args) {
        int value = decode("26");
        System.out.println(value);
    }

    static int decode (String a) {
        Map<String,String> map = new HashMap<>();
        int counter = 0;

        map.put("1","A");
        map.put("2","B");
        map.put("6","F");
        map.put("26","z");

        if (a.length() == 1) {
            if (map.get(a) != null) {
                counter++;
                return counter;
            }
        }
        else if(a.length() > 1) {
            if (map.get(a)!=null) {
                counter ++;
            }
            Integer ii = Integer.valueOf(a);
            int b = ii/10;
            int c = ii%10;

            if (map.get(String.valueOf(b)) != null && map.get(String.valueOf(c)) != null) {
                counter++;
                return counter;
            }

        }
        // nothing found
        return counter;
    }
}
