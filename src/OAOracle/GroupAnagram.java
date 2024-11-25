package OAOracle;

import java.util.*;

public class GroupAnagram {

    public static void main(String[] args) {
        String [] string = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groups = groupAnagram(string);
        System.out.println(groups);
    }

    static List<List<String>> groupAnagram(String [] string) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : string) {
            // convert to array, sort it , and then store it as map key
            // this will provide the signature to group them together ...

            char [] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String signature = new String (charArray) ;

            // check if signature exists in map ...
            if (!map.containsKey(signature)) {
                map.put(signature,new ArrayList<>());
            }
            // add the word to corresponding group
            map.get(signature).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
