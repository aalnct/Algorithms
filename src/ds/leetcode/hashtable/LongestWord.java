package ds.leetcode.hashtable;

import java.util.*;

/**
 * Created by AmitAgarwal on 6/10/20.
 */
public class LongestWord {

    public static void main(String[] args) {
        String[] words = new String[] {"a", "bannana" , "app", "appl", "ap", "apple", "apply"};
        String  result = longestWord(words);

        String r = longestWordDelete("",new ArrayList<>());
        System.out.println(r);
    }

    public static String longestWord(String[] words){
        Arrays.sort(words);
        String length = "";
        Map<String,Integer> map = new HashMap<>();
        map.put("",1);
        for(int i=0;i<words.length;i++){
            if(map.containsKey(words[i].substring(0,words[i].length()-1))){
                map.put(words[i], words[i].length());

                if(length.length() < words[i].length()){
                    length = words[i];
                }
            }

        }
        return length;
    }


    public static String longestWord2(String[] words){
        Arrays.sort(words);
        String longest = "";
        Set<String> set = new HashSet<>();
        set.add("");

        for(int i=0; i< words.length;i++){
            String current = words[i];

            if(set.contains(current.substring(0,current.length()-1))){
                set.add(current);

                if(longest.length() < current.length()){
                    longest = current;
                }
            }
        }
        return longest;
    }


    public static String longestWordDelete(String s, List<String> delete){
        String result = "";
        s = "abpcplea";
        delete = Arrays.asList("ale","apple","monkey","plea");
        for(int i=0;i<delete.size();i++){
            for(int j=0;j<s.length();i++){
                
            }
        }

        return "";
    }
}
