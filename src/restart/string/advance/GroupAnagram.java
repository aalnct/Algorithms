package restart.string.advance;

import java.util.*;

public class GroupAnagram {

    public static void main(String[] args) {
        String [] array = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagram(array);

        for (List<String> resultString : result) {
            System.out.println(resultString);
        }
    }

    static List<List<String>> groupAnagram(String [] stringArray) {
        if (stringArray == null || stringArray.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : stringArray) {
            char [] charArray = str.toCharArray();

            Arrays.sort(charArray);

            String sorted = new String(charArray);

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(str); // this will group string of same characters
        }

        return new ArrayList<>(map.values());
    }

}
