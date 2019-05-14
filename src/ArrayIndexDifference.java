import java.util.HashMap;
import java.util.Map;

/**
 * Created by AmitAgarwal on 11/21/18.
 */
public class ArrayIndexDifference {

    public static void main(String[] args){
        int [] array = {1, 3, 5, 4, 8, 2, 4, 3, 6, 5};
        returnIndex(array);
    }

    private static int returnIndex(int [] array){
        int x = 2;
        int y = 5;
        int storeIndex = -1;
        int tempKey = -1;
        Map<Integer,Integer> map = new HashMap<>(array.length);
        for(int i=0; i < array.length; i++){
            if(array[i] == x){
                if(map.containsValue(x)){
                    for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                        tempKey = entry.getKey();
                        findDifference(tempKey, x);
                    }
                }
                storeIndex = i; //will store the index of current encountered element - which we are looking for
                map.put(storeIndex, array[i]);
            }
        else if(array[i] == y){
                if(map.containsValue(y)){
                    for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                        tempKey = entry.getKey();
                        findDifference(tempKey,y);
                    }
                }
                storeIndex = i;
                map.put(storeIndex, array[i]); //for second value we are looking for
            }
        }



        return -1;
    }

    private static int findDifference(int key, int value){
        System.out.println("Existing key (index) " + key + " for value () : " + value);
        return -1;
    }

}
