package ds.leetcode.StringSolutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AmitAgarwal on 6/4/20.
 */
public class FindCommonCharacters {

    public static void main(String[] args) {
        String [] array = new String[] {"bella","label","roller"} ;
        List<String> list= findCommonCharacters(array);
        list.forEach(l -> System.out.println(l));
    }

    public static List<String> findCommonCharacters(String[] array){
        Map<Character,Integer> result = new HashMap<>();
        for(String s: array){
            // temporary map
            Map<Character,Integer> temp = new HashMap<>();
            for(char c : s.toCharArray()){
                // storing along with the frequency
                temp.put(c, temp.getOrDefault(c,0)+1);
            }

            if(result.isEmpty()){
                for(char c : temp.keySet()){
                    result.put(c, temp.get(c)); // copying from temp to result map
                }
            }else { // why are we doing this ??
                for(char c : result.keySet()){
                    int valueForReplacement = temp.getOrDefault(c,0);
                    result.put(c, Math.min(valueForReplacement,result.get(c)));
                }
            }
        }

        List<String> list = new ArrayList<>();
        for(Character c : result.keySet()){
            for(int i=0;i<result.get(c);i++){
                list.add(c.toString());
            }
        }

        return list;
    }
}
