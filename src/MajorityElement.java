import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by AmitAgarwal on 11/20/18.
 */
public class MajorityElement {

    public static void main(String [] args){
        /*int [] array = {1,8,7,4,1,2,2,2,2,2,2};*/
        int [] array = {1,1,1,1,1,1,5,7,0,8,2};
        int response = findMajority(array);
        if(response == -1){
            System.out.println("No Majority Element is present");
        }else{
            System.out.println("Majority Element is present  : " + response);
        }


        /**
         * linear time and constant space approach
         */
        int res = majorityElement(array);
        System.out.println("Majority element is :" + res);

    }

    private static int findMajority(int [] array) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (array.length <= 0) {
            return 0;
        }

        for (int i = 0; i < array.length; i++) {
            checkMapIsNull(array,map);
            map.put(array[i], map.get(array[i]) + 1);
        }

        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> pair = it.next();
            if (pair.getValue() > array.length / 2) {
                return pair.getValue(); //total count of majority element present
            }
            it.remove();//to avoid concurrent modification exception
        }

        return -1;
    }

    private static void checkMapIsNull(int[] array, Map<Integer,Integer> map){
        for(int i=0;i<array.length;i++){
            if(!map.containsKey(array[i])){
                map.put(array[i], 0);
            }
        }
    }


    private static int majorityElement(int [] array){
        if(array.length<=0){
            return 0;
        }

        //m stores majority element if present
        int m = -1;
        //counter
        int i = 0;

        //for each element
        for(int j=0;j<array.length;j++){
            if(i == 0){
                m = array[j];
                //reset counter to 1
                i = 1;
            }
            else if(m == array[j]){
                //increment counter if current candidate
                i++;
            }else{
                //decrement the counter if not current candidate
                i--;
            }
        }
        return m;
    }

}
