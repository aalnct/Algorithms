package ds.leetcode.StringSolutions;

/**
 * Created by AmitAgarwal on 5/26/20.
 */
public class OddCountCharacters {
    public static void main(String[] args) {
        String result = generateTheString(7);
        System.out.println(result);
    }


    public static String generateTheString(int n){
        String str1 = "";
        String str2 = "b";
        if(n%2 == 0){ //n is even
         for(int i=1;i<n;i++){ // nis 4, that means it will print 3 times
             str1 = str1.concat("a");
         }
         str1 = str1.concat("b");
        }
        else {
            for(int i=1;i<=n;i++){
                str1 = str1.concat(str2);
            }
        }
        return str1;
    }
}