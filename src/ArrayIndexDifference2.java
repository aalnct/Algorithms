import javax.lang.model.type.IntersectionType;

/**
 * Created by AmitAgarwal on 11/22/18.
 */
public class ArrayIndexDifference2 {

    public static void main(String [] args){
        int [] array = {1, 3, 5, 4, 8, 2, 4, 3, 6, 5};
        int x = 2;
        int y = 5;
        int diff = findMinDifference(array,x,y);
        if(diff!=Integer.MAX_VALUE){
            System.out.println(diff);
        }
    }


    private static int findMinDifference(int [] array, int x, int y){
        int n = array.length;
        int x_index = n;
        int y_index = n;
        int min_difference = Integer.MAX_VALUE;

        for(int i=0;i<array.length;i++){
            if(array[i] == x){
                x_index = i;
                //if y is seen before
                if(y_index != n){
                    min_difference = Integer.min(min_difference, Math.abs(x_index - y_index));
                }
            }
            else if(array[i] == y){
                y_index = i; //set current index to y
                //if x is seen before
                if(x_index != n){
                    min_difference = Integer.min(min_difference, Math.abs(x_index-y_index));
                }
            }
        }
    return min_difference;
    }
}
