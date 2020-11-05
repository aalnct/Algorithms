package searching;

/**
 * Created by AmitAgarwal on 5/8/20.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] n  = {1,2,3,4,5,6,7,8};
        int x1 = 2;
        int i = binarySearch(n,x1);
        System.out.println(i);
    }

    /**
     *
     * @param a - array
     * @param x - target
     * @return
     */
    public static int binarySearch(int [] a, int x){ // x is the target element
        int p = 0;
        int r = a.length-1;
        while(p<=r){
            int pivot = (p + r)/2;
            if(x == a[pivot]){
                return pivot;
            }else {
                if(a[pivot] > x){
                    r = pivot-1;
                }else if(a[pivot] < x){
                    p = pivot+1;
                }
            }
        }
        return -1;
    }


    /*private static int searchBinaryInsertPosition(int [] array, int target){
        int p = 0; // first element index
        int q = array.length-1; // last element index
        int last = q;
        int first = p;

        while(p<=q){ // should not cross the loop itself
            int pivot = (p+q)/2; // will provide the center/mid of array
            if(p==q && target<=array[p]){
                return p;
            }
            if(target == array[pivot]){
                return pivot;
            }
            if(target < array[pivot]){
                q = pivot-1;
                if(target < array[first]){
                    return 0;
                }
                if(target < array[q] && target < first){
                    return 0;
                }else if(target < array[q]){
                    for(int i=0;i<=q;i++){
                        if(array[i] >= target){
                            return i;
                        }
                    }
                    return q;
                }
            }else if(target > array[pivot]){
                p = pivot+1;
                if(p >= array.length){
                    return p;
                }
                if(target < array[p]){
                    return p;
                }
            }
        }
        if(target > array[last]){
            return array.length;
        }
        return 0; // else just return 0, since that will be first index where this value should be
    }*/
}