/**
 * Created by AmitAgarwal on 11/23/18.
 */
public class Recursion {
    public static void main(String [] args){
        reduceByOne(10);
    }

    private static void reduceByOne(int n){
        if(n>=0){//base case
            reduceByOne(n-1);//recursion technique
        }
        System.out.println(n); //n=-1 will be printed
    }
}
