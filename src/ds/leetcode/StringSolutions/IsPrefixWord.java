package ds.leetcode.StringSolutions;

/**
 * Created by AmitAgarwal on 6/30/20.
 */
public class IsPrefixWord {

    public static void main(String[] args) {
        int i = isPrefixWord("hello from the other side","pill");
        System.out.println(i);
    }

    public static int isPrefixWord(String sentence, String searchWord){
        String [] str = sentence.split(" ");
        for(int i=0;i<str.length;i++){
            if(str[i].length() >= searchWord.length() &&
                    searchWord.equals(str[i].substring(0,searchWord.length()))){
                return i+1;
            }
        }
        return -1;
    }
}
