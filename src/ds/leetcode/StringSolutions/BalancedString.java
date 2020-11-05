package ds.leetcode.StringSolutions;

/**
 * Created by AmitAgarwal on 5/23/20.
 */
public class BalancedString {
    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        int result =balancedStringSplit(s);
        System.out.println(result);
    }

    public static int balancedStringSplit(String s){
        int count_L = 0;
        int count_R = 0; // both should be equal (these two to check if L and R are same)
        int countL = 0;
        int countR = 0; // these two to keep tap of balanced subStrings
        int subStringCount = 0;

        for(int i=0;i<s.length();i++){
            if('L' == s.charAt(i)){
                count_L ++;
            }else if('R' == s.charAt(i)){
                count_R ++;
            }
        }

        if((count_L == count_R)){
            char[] stringArray = s.toCharArray();
            for(int i=0; i<stringArray.length;i++){
                if(s.charAt(i) == 'L'){
                    countL++;
                }else if(s.charAt(i) == 'R'){
                    countR++;
                }

                if(countL == countR){
                    countL = 0;
                    countR = 0;
                    subStringCount++;
                }

            }
        }
        return subStringCount; //if not balanced
    }


}
