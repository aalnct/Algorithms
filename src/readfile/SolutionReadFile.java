package readfile;

import java.util.Scanner;

/**
 * Created by AmitAgarwal on 3/17/19.
 */
public class SolutionReadFile {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        for(int i=1;s.hasNext();i++){
            System.out.println(i + " " + s.nextLine());
        }


    }
}
