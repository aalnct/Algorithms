/**
 * Created by AmitAgarwal on 11/23/18.
 */
public class BinarySearchProblem {

    public static void main(String [] args){
        int [] array = {1,2,3,4,5,6};//first rule of binary search - array should be sorted
        int x = 3;
        int result = binarySearch(array,x);
        System.out.print(result);
    }

    private static int binarySearch(int [] array, int x){
        int p = 0; //initial index
        int r = array.length-1; //last index
        while(p<=r){
            int q = (p+r)/2; //mid point
            if(x<array[q]){
                r = q-1;
            }
            else if(x>array[q]){
                p = q+1;
            }else{
                return q;
            }
        }
        return -1;

    }
}
