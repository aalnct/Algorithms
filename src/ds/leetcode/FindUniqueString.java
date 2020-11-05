package ds.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AmitAgarwal on 5/11/20.
 */
public class FindUniqueString {

    public static void main(String[] args) {
        String str = "loveLeetCode";
        firstUniqueCharacter(str);
    }

    public static int firstUniqueCharacter(String s){
        Map<Character,Integer> map = new HashMap<>();
        int len = s.length();
        //build map with character and keep the count of how many times they have occured
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        //find the index
        for(int i=0;i<len;i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
