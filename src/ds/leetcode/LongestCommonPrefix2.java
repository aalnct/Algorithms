package ds.leetcode;

/**
 * Created by AmitAgarwal on 5/10/20.
 */
public class LongestCommonPrefix2 {


    public static void main(String[] args) {
        String[] s = {"flower" ,  "flow" ,  "flight"};
        String str = findLCM(s);
        System.out.println(str);
    }

    public static String findLCM(String [] str){
        if(str.length == 0) return "";
        String prefix = str[0]; // First array value as prefix
        for(int i=1; i< str.length;i++){
            while(str[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        } return prefix;
    }

}
