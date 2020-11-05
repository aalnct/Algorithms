package ds.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AmitAgarwal on 5/10/20.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        findLCP();
    }

    public static String findLCP(){
        int j = 0;
        String[] lcpArray = {"flower" ,  "flow" , "flight"};
        Map<Character,Integer> charMap1 = new HashMap<>();
        Map<Character,Integer> charMap2= new HashMap<>();

        if(lcpArray.length == 0){
            return "";
        }
        for(int i=0;i<lcpArray.length-1;i++){
            int length1 = lcpArray[i].length();
            int length2 = lcpArray[i+1].length();
            char[] ch3 = new char[length1]; // initialize char array to length of first string in string array
            while(length1 !=0 && length2 != 0 ){
                char ch1 = lcpArray[i].charAt(j);
                char ch2 = lcpArray[i+1].charAt(j);
                if(ch1 == ch2 && j == lcpArray.length){
                    ch3[i] = ch2;
                    if(charMap1.containsKey(ch3[i])){
                        charMap1.put(ch3[i] , i);
                        charMap1.forEach((k,v) -> {
                            System.out.println(k);
                        });
                    }
                    else {
                        charMap2.put(ch3[i] , i);
                        /*charMap2.forEach((k,v) -> {
                            System.out.println(k);
                        });*/
                    }
                    //System.out.print(ch3[i]);
                }
                j++;
                length1--;
                length2--;
            }
            j = 0; // resetting it back to 0, else index out of bound exception will be thrown
        }
        return "";
    }
}
