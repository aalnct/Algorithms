package ds.leetcode.StringSolutions;

import java.util.Arrays;

/**
 * Created by AmitAgarwal on 6/23/20.
 */
public class RearrangeWords {

    public static void main(String[] args) {
        String str = "leetcode is cool";
        System.out.println(rearrangeWords(str));
    }

    public static String rearrangeWords(String str){
        String[] word = str.split(" ");
        Arrays.sort(word , (s1,s2) -> Integer.compare(s1.length(),s2.length()));
        StringBuilder sb = new StringBuilder();
        sb.append(word[0].substring(0,1).toUpperCase() + word[0].substring(1)); // first letter as upper case

        for(int i=1; i< word.length;i++){
            sb.append(" " + word[i].toLowerCase());
        }
        return sb.toString().trim();
    }
}
