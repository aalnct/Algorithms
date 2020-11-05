package ds.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by AmitAgarwal on 5/10/20.
 */
public class JewelsAndStones {

    public static int findJewels(String stones, String jewels) {
        Set<Character> bag = new HashSet<>();
        for(char c : jewels.toCharArray()){
            bag.add(c);
        }
        int count = 0;
        for(char c : stones.toCharArray()){
            if(bag.contains(c)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String stone = "aABBCA";
        String jewel = "zz";
        int count  = findJewels(stone,jewel);
        System.out.println(count);
    }
}
