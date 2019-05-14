package AmazonInterview;

import java.util.Arrays;

/**
 * Created by AmitAgarwal on 4/2/19.
 */
public class LargestElement {
    public static void main(String [] args){
        int [] array = {2 , 99, 8, 9, 54, 67, 0};
        int find = 9;
        Arrays.sort(array);
        for(int i = 0; i < array.length;i++){
            if(find == array[i]){ //O(n)
                System.out.println("found required element");
            }else{
                System.out.println("Cannot find required element");
            }
            System.out.println(array[i]);
        }
        //find in O(1)
    }
}
