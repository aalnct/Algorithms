package ds.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AmitAgarwal on 5/11/20.
 */
public class RansomNote {

    static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        String ransomNote = "aad";
        String magazine = "aa";
       boolean result =  canConstruct(ransomNote,magazine);
        System.out.println(result);
    }

    public static boolean canConstruct(String ransomNote, String magazine){
        for(char c : magazine.toCharArray()){
            if(map.containsKey(c)){
                map.put(c , map.get(c)+1);
            }else {
                map.put(c, 1);
            }
        }

        for(char c : ransomNote.toCharArray()){
            if(map.containsKey(c)){
                if(map.get(c) >1){
                    map.put(c, map.get(c)-1);
                }else {
                    map.remove(c);
                }
            }else  {
                return false;
            }
        }
        return true;
    }
}
