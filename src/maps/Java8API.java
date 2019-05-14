package maps;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by AmitAgarwal on 3/13/19.
 */
public class Java8API {

    private int id =0;
    private String name = "";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static Map<Integer,BigInteger> memorize = new HashMap<>();

    public static void main(String[] args){

        Java8API ob1 = new Java8API();
        Java8API ob2 = new Java8API();


        System.out.println(ob1 == ob2);
        System.out.println("Equals *** ");
        System.out.println(ob1.equals(ob2));


        Set<Integer> set = new HashSet();

        set.add(1);
        set.add(1);
        set.add(2);

        Optional.ofNullable(set).orElse(Collections.emptySet()).forEach(s -> System.out.println(s));



        List<String> numbers = Arrays.asList("1","2","3","4","5","6");
        System.out.print("Original Numbers " + numbers);

        //.map() --> function will convert the stream of string to integer
        //and then filter will be appiled to integer stream and check for maths function
        //and finally .collect function will return the entire list of integer

        List<Integer> even = numbers.stream().map(s -> Integer.valueOf(s)).filter(number -> number%2 == 0)
                                                        .collect(Collectors.toList());



        List<Integer> all = numbers.stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList());


        System.out.println(System.lineSeparator());
        System.out.println("processed list " + even);
        System.out.println(System.lineSeparator());
        System.out.println("list " + all);

        memorize.put(0,BigInteger.ZERO);
        memorize.put(1,BigInteger.ONE);
        //memorize.put(2,BigInteger.TEN);
        memorize.put(3,BigInteger.ONE);

        for(int i=0; i<100; i++){
            System.out.println("Printing ::: " + fabonaci(i));
        }


    }

    private static BigInteger fabonaci(int n){
        if(memorize.containsKey(n)){
            return memorize.get(n);
        }else {
            BigInteger result = fabonaci(n-1).add(fabonaci(n-2));
            memorize.put(n,result);
            return result;
        }

    }


    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o ==  null && getClass()!=o.getClass()) return false;
        Java8API simpson = (Java8API) o;
        return id == simpson.id &&
                name.equals(simpson.name);
    }



}
