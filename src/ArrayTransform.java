import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by AmitAgarwal on 11/23/18.
 */
public class ArrayTransform {
    public static void main(String[] args){
        int[] array = {10,4,9,2,1};
        transform(array);
        System.out.print(Arrays.toString(array));

    }

    private static void transform(int [] array){
        Map<Integer,Integer> map = new TreeMap<>();
        int rank = 1;//first element rank will be 1

        for(int i=0;i<array.length;i++){
            map.put(array[i],i);
        }
        //keys are stored in sorted order in tree map

        //iterating map to assign rank to each element
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            array[entry.getValue()] = rank++;
        }
    }
}
