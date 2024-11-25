package abstractfactory;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;


public class OCPJP  {

    String personName;

    LocalDateTime localDateTime;

    public static void main(short[] args) {



    }


    public static void main(String[] args) {



        final int leg = 0;
        String legOfRabbit = "4";


        List<String> names = new ArrayList<>();
        names.add("Java");
        names.add("Kotlin");
        names.add("Javascript");
        names.add("Rubby");

        names.removeIf(name -> name.length() <=5);
        System.out.println(names);

        System.out.println(11/2);
        System.out.println(10/2.0);
        System.out.println(11 % 2);
        System.out.println(10 % 2.0);



        OCPJP person = new OCPJP();
        person.personName = "Alex";
        checkPerson(person, userName -> userName.personName.equals("Alex"));

        Integer i1 = null;
       // int i21 = i1;
        System.out.println(i1);


        System.out.print("Hi");
        System.out.print(" Java");
        System.out.println("Developers");;



        int [] nums = new int[] {2,3,5,6,10,14,20,34};
        System.out.println(Arrays.binarySearch(nums,5));

        BufferedInputStream bis = new BufferedInputStream(null);


        List<Integer> list = new ArrayList<>();
        for (int i=0; i <= 15; i++) {
            list.add(i);
        }
        System.out.println(Collections.binarySearch(list,16));





        int x = 2;
        int y = 7;
        int z = 1;

        do {
            ++x;
            y--;
            z *= x+y;
        }
        while (x < y) ;
            System.out.println(z);

            int a = 2;
            switch (a) {
                case 1 :
                    System.out.println("Hi");
                case 2:
                    System.out.println("Hello");
                    break;

            }

            Object object = "10";
            // Integer integer = (Integer)object;
       //  s System.out.println(integer);


            StringBuffer buffer = new StringBuffer("");


            String lan1 = "Java";
            String lan2 = new String(lan1);
        System.out.println("Java".equals(lan2)); // true
        System.out.println(lan1 == lan2); // false
        System.out.println(lan2.equals(lan1)); // true
        System.out.println("Java" == lan1); // true
        System.out.println("Java" == lan2); // false


        x = 8;
        y = 9;
        z = 10;
        System.out.println(++x * y-- % ++z);


        x = 3 + 2 * 5-7;
        y = x * 3%6;
        System.out.println(x / y);


        String []  cars = new String [] {"", "", ""};

        Integer i = 7;
        int i2 = i;
        Character c = 'A';
        char c2 = c;
    }

    private static void checkPerson(OCPJP person, Predicate<OCPJP> check) {
        String message = check.test(person) ? "Welcome" : "Unknow";
        System.out.println(message);
    }

    public double calculate() {
        return 2.5;
    }


}
