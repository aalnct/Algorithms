package ds.leetcode.StringSolutions;

import java.util.*;

/**
 * Created by AmitAgarwal on 5/25/20.
 */
public class DestinationCity {

    public static void main(String[] args) {
        String string1 = "London";
        String string2 = "NewYork";

        String string3 = "NewYork";
        String string4 = "Lima";

        String string5 = "Lima";
        String string6 = "SanJose";

        List<String> listString = new ArrayList<>();
        List<String> listString1 = new ArrayList<>();
        List<String> listString2 = new ArrayList<>();
        List<List<String>> listOfListString = new ArrayList<>();

        listString.add(string1);
        listString.add(string2);

        listString1.add(string3);
        listString1.add(string4);

        listString2.add(string5);
        listString2.add(string6);

        listOfListString.add(listString);
        listOfListString.add(listString1);
        listOfListString.add(listString2);

        String destination = destCity(listOfListString);
        System.out.println(destination);

    }

    public static String destCity(List<List<String >> path){
        Map<String,Integer> map = new HashMap<>();
        String res = "";
        for(List<String> list : path){
            String out = list.get(0);
            String in = list.get(1);

            map.put(out,map.getOrDefault(out,0)-1);
            map.put(in,map.getOrDefault(in,0)+1);
        }

        for(String city : map.keySet()){
            if(map.get(city) > 0){
                res = city;
            }
        }
        return res;
    }
}
