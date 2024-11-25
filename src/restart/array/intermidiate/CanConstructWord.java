package restart.array.intermidiate;

import java.util.HashMap;
import java.util.Map;

public class CanConstructWord {

    public static void main(String[] args) {
        String target = "abcdef";
        String [] wordBank = {"ab", "abc", "cd", "def", "abcd"};
        System.out.println(canConstruct(target,wordBank));
    }

    static boolean canConstruct (String target, String [] wordBank) {
        Map<String,Boolean> map = new HashMap<>();
        return canConstructHelper(target,wordBank,map);
    }

    static boolean canConstructHelper (String target, String [] wordBank,
                                       Map<String,Boolean> map) {


        if (map.containsKey(target)) {
            return true;
        }
        if (target.equals("")) {
            return true;
        }

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                if (canConstructHelper(suffix,wordBank,map)) {
                    map.put(target,true);
                    return true;
                }
            }
        }
        map.put(target,false);
        return false;

    }

}
