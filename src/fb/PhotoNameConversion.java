package fb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PhotoNameConversion {

    public static void main(String[] args) {
        convertName("photo.jpg, Warsaw, 2013-09-05 14:08:15");
    }

    static String convertName (String s) {
        // we can add in a list for later comparison using comparator
        List<String> list = new ArrayList<>();

        // converting to string array to fetch extension, name and time
        String[] s1 = s.split(",");
        // we do not need any loop here since we already know that s1[0] will always be name with extension
        for (int i=0;i<s1.length;i++) {
            s1[i] = s1[i].substring(s1[i].indexOf('.'));
            list.add(s1[i]);
        }


        // putting the photos based on group;


        /*for (String ss : list) {
            System.out.print(ss);
        }*/

        s = s1[1].concat(s1[0]);

        System.out.println(s);

        return s;
    }
}
