/**
 * Created by AmitAgarwal on 11/23/18.
 */
public class ArrayLinearSearch {
    public static void main(String [] args){
        int [] array = {5,8,1,0,4,2};
        int result  = linearSearch(array,4);
        System.out.print(result);
    }
    //O(n) - worst case scenario - going through entire elements
    private static int linearSearch(int [] array, int x){
        for(int i=0;i<array.length;i++){
            if(array[i] == x){
                return i;
            }
        }
        return -1;
    }
}
