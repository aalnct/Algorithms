package ds.leetcode.StringSolutions;

import java.util.*;

/**
 * Created by AmitAgarwal on 6/12/20.
 */
public class MostCommonWord {

    public static void main(String[] args) {
        String str = "Bob hit a ball, the hit BALL flew far after it was hit".toLowerCase();
        str = "a, a, a, a, b,b,b,c, c".toLowerCase();
        String[] banned = new String[] {"a"};
        String output = mostCommonWord1(str,banned);
        System.out.println(output);
    }

    public static String mostCommonWord(String str, String[] banned){
        Map<String,Integer> map = new HashMap<>();
        str = "Bob hit a ball, the hit BALL flew far after it was hit".toLowerCase();
        banned = new String[] {"hit"};
        for(int i=0;i<banned.length;i++){
            if(str!=null && !str.isEmpty() && str.contains(banned[i])){
                str = str.replace(banned[i],"");
            }
        }

        System.out.println(str);

        String [] array = str.split(" ");

        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i])){
                map.put(array[i], map.get(array[i]) + 1);
            }else {
                map.put(array[i], 1);
            }
        }
        return str;
    }


    public static String mostCommonWord1(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();

        for (String b : banned) {
            set.add (b);
        }

        Map<String, Integer> map = new HashMap<>();
        String ans = "";
        int count = 0;
        for (String s : paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" *(,|=>| ) *")) {
            s = s.trim();
            if (s.length() == 0 || set.contains (s))
                continue;
            map.put(s, map.getOrDefault(s, 0) + 1);
            if (count < map.get(s)) {
                count = map.get(s);
                ans = s;
            }
        }
        return ans;
    }

}
