package bitset;

import java.util.BitSet;

/**
 * Created by AmitAgarwal on 3/24/19.
 */
public class BitSetSolution {


    public static void main(String [] args){

        BitSet bit1 = new BitSet();
        BitSet bit2 = new BitSet();


        bit1.set(0);

        bit1.set(5);

        System.out.println(bit1.get(0));

        for(int i=0;i < bit1.nextSetBit(5);i++){
            System.out.println(i);
        }

        System.out.println(bit1.get(1));




    }
}
