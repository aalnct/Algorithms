package restart.array.advance;

import java.util.*;

public class GroupAnagram {

    public static void main(String[] args) {
        String [] array = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagram(array);

        for (List<String> a : result) {
            System.out.println(a);
        }
    }

    static List<List<String>> groupAnagram (String [] stringArray) {
        if (stringArray == null || stringArray.length == 0) {
            return new ArrayList<>();
        }

        Map<String,List<String>> group = new HashMap<>();

        for (String str : stringArray) {
            char [] charArray = str.toCharArray();

            Arrays.sort(charArray);

            // convert it back to string
            String updated = new String(charArray);

            if (!group.containsKey(updated)) {
                group.put(updated,new ArrayList<>());
            }
            group.get(updated).add(str);
        }

        return new ArrayList<>(group.values());
    }
}
