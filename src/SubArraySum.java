/**
 * Created by AmitAgarwal on 11/23/18.
 */
public class SubArraySum {
    public static void main(String [] args){
        int[] array = { 6, -4, -3, 2, 3 };
        int i = partition(array);

        if(i!=-1){
            //right and left partition
            printArray(array,0,i-1);
            printArray(array,i,array.length-1);
        }
    }

    private static int partition(int[] array){
        for(int i=0;i<array.length;i++){

            int left = 0;

            for(int j=0;j<i;j++){
                left +=array[j];
            }

            int right = 0;
            for(int j=i;j<array.length;j++){
                right +=array[j];
            }

            if(right == left){
                return i;
            }
        }
        //invalid input
        return -1;
    }

    private static void printArray(int [] array,int i,int j){
        for(int k = i; k <=j; k++){
            System.out.print(array[k] + " ");
        }

        System.out.print("\n");

    }
}
