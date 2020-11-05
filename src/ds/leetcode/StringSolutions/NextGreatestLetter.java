package ds.leetcode.StringSolutions;

/**
 * Created by AmitAgarwal on 6/14/20.
 */
public class NextGreatestLetter {

    public static void main(String[] args) {
        char[] letter = new char[]{'c', 'f', 'j'};
        char target = 'j';
        char l = nextGreatestLetter(letter,target);
        System.out.println(l);
    }

    // binary search

    public static char nextGreatestLetter(char[] letters, char target){
        int p = 0;
        int q = letters.length-1;
        while(p<=q){
            int pivot = p + (q - p) / 2;
            if(target<letters[pivot]){
                q = pivot-1;
            }
            else
                if(target >= letters[pivot]){
                p = pivot+1;
            }
        }
        return letters[p % letters.length];
    }
    public static char nextGreatestLetter1(char[] letters, char target) {
        int lo = 0;
        int hi = letters.length;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (letters[mi] <= target){
                lo = mi + 1;
            }
            else{
                hi = mi;
            }
        }
        return letters[lo % letters.length];
    }

    // linear search

    public static char nextGreatestLetter_Linear(char[] letters, char target){
        for(char c : letters){
            if(c>target){
                return c;
            }
        }
        return letters[0];
    }
}
