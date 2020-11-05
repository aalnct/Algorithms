package ds.leetcode.StringSolutions;

import java.util.*;

/**
 * Created by AmitAgarwal on 5/30/20.
 */
public class SecondMostString {

    public static void main(String[] args) {
        String result = repeatedString();
        System.out.println(result);
    }

    public static String repeatedString(){
        String str = "aaa bbb aaa aaa bbb"; //output bbb
        String[] strArray = str.split(" ");

        Map<String , Integer> map = new HashMap<>();

        for(String s : strArray){
            if(map.containsKey(s)){
                map.put(s, map.get(s) + 1);
            }else {
                map.put(s, 0);
            }
        }

        Iterator<Map.Entry<String,Integer>> itr = map.entrySet().iterator();

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        while(itr.hasNext()){
            Map.Entry<String,Integer> entry = itr.next();
            int value = entry.getValue();

            if(value > firstMax){
                secondMax = firstMax;
                firstMax = value;
            }

            else if(value > secondMax && value != firstMax){
                secondMax = value;
            }
        }

        itr = map.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<String,Integer> entry = itr.next();
            int value = entry.getValue();
            if(value == secondMax){
                return entry.getKey();
            }
        }

        //System.out.println(strArray);
        return "";
    }
}
