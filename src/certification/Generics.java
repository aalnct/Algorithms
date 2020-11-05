package certification;

import java.util.*;

/**
 * Created by AmitAgarwal on 1/16/20.
 */
public class Generics<T extends Number> {

    public Generics(){}

    public T var;

    public Generics(T var) {
        this.var = var;
    }

    T getVar(){
        return var;
    }

    public static void main(String [] args){

        LinkedList<?> list1 = null;
        LinkedList<? extends Number> list2 = null;

        list1 = list2;

        PriorityQueue<?> pr1 = null;
        PriorityQueue pr2 = null;
        pr2 = pr1;
        pr1 = pr2;

        List<? extends Number> list = new ArrayList<>();


        List<? extends Integer> list9 = new ArrayList<>();
        Integer f = list9.get(0);




        /**
         * elements cannot be added, since compiler is not sure what kind of list is
         * being used
         */

        for(Number i : list){
            System.out.println(i);
        }

        Integer input = 0;
        Generics data = new Generics<Number>(input);
        /**
         * Cast to Integer since Number cannot be assign to Integer
         */
        Integer output = (Integer) data.getVar();

        Map map = new HashMap<String,Integer>();

        /**
         * all below given will throw compile time exception
         */
        /*Map<> map1 = new HashMap<String,Integer>();*/
        /*Map<String, Number> map1 = new HashMap<String, Integer>();*/
        /*Map<Object, Object> map1 = new HashMap<String, Integer>();*/
    }

    void say(Set<Double> set){

    }

    void say(Set<Double>... set){

    }
}
