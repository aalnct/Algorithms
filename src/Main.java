import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        String path = System.getProperty("user.dir") + "/src/test.rtf";
        Charset ecoding = Charset.defaultCharset();
        List<String> line  = Files.readAllLines(Paths.get(path),ecoding);
        System.out.println(line);


        /**
         * Second - creating string from a file
         */
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        String lineString = new String(encoded, ecoding);
        System.out.println(lineString);

        /**
         * given a unsorted array of integers, find a pair with the given sum in it
         */

        int [] array = {9, 7,2, 5, 3, 1};

        int sum = 10;

        if(array.length >0 ){
            for(int i = 0; i<=array.length;i++){
                for(int j = i+1; j <=array.length-1;j++){
                    if(sum == array[i] + array[j]){
                        System.out.println(array[i] + " && " + array[j]);
                    }else{
                        continue;
                    }
                }
            }
        }

        /**
         * O(nlog(n))
         */
        pairSort(array,sum);
        findPair(array,sum);

    }

    private static void pairSort(int[] array, int sum){
        Arrays.sort(array); //sort the array
        int low = 0;
        int high = array.length - 1;
        int numberOfPairs = 0;
        //loop till low is less than high
        while(low < high){

            if(array[low] + array[high] == sum){
                numberOfPairs++;
                System.out.println("Pair found :" + array[low] + " && " + array[high]);
            }

            if(array[low] + array[high] < sum){
                low++;
            }else{
                high--;
            }

        }
        System.out.println("Total " + numberOfPairs);

        if(numberOfPairs == 0){
            System.out.println("Pair not found");
        }

    }

    private static  void findPair(int[] array, int sum){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i= 0; i<array.length;i++){
            if(map.containsKey(sum-array[i])){
                System.out.println("Pair found at index: " + map.get(sum-array[i]) + " and " + i);
                return;
            }
            //Store index of current element in a map
            map.put(array[i],i);
        }
        System.out.println("No Pair found");
    }

}
