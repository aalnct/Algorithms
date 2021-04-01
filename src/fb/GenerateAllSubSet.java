package fb;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubSet {

    public static void main(String[] args) {

    }

    static String[] generateAllSubSet (String s){
        List<String> result = new ArrayList<>();
        char[] partial = new char[s.length()];
        subSets (s,0,partial,0,result);
        String[] strArray = new String[result.size()];

        return result.toArray(strArray);
    }

    static void subSets (String s, int start, char[] partial,
                         int len, List<String> result) {
        if (start >= s.length()) {
            result.add(new String(partial,0,len));
            return;
        }

        subSets(s,start+1, partial,len,result);
        partial[len] = s.charAt(start);
        subSets(s,start+1, partial,len+1,result);
    }
}
