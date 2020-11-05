package ds.leetcode.StringSolutions;

/**
 * Created by AmitAgarwal on 5/26/20.
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        String string = "a ";
        int result = lengthOfLastWord(string);
        System.out.println(result);
    }


    public static int lengthOfLastWord(String s){
        int length = s.length()-1;
        int result = 0;

        if((s.length() ==0 && s.isEmpty()) || s.indexOf(' ')==-1){
            return s.length();
        }
        while(length>0 && s.charAt(length) == ' '){
            length--;
        }
        while(length>=0 && s.charAt(length)!=' '){
            length--;
            result++;
        }
        return result;
    }
}
