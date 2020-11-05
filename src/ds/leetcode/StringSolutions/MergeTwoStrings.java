package ds.leetcode.StringSolutions;

/**
 * Created by AmitAgarwal on 5/30/20.
 */
public class MergeTwoStrings {

    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Bye";
        String result = mergeStrings(str1,str2);
        System.out.println(result);
    }

    public static String  mergeStrings(String str1, String str2){
        StringBuilder sbr = new StringBuilder();

        for(int i=0; i< str1.length() || i < str2.length(); i++){
            if(i < str1.length()){
                sbr.append(str1.charAt(i));
            }
            if(i < str2.length()){
                sbr.append(str2.charAt(i));
            }
        }

        return sbr.toString();
    }
}
