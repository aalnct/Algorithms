package ds.leetcode.StringSolutions;

/**
 * Created by AmitAgarwal on 5/28/20.
 */
public class ReverseString {

    public static void main(String[] args) {
        char [] s = new char[0];
        reverseString(s);
    }

    public static void reverseString(char[] str){
        int i = 0;
        int j = str.length-1;
        char temp;

        while(i<j){
            temp = str[i];
            str[i] = str[j];
            str[j]=temp;
            i++;
            j--;
        }
    }
}
