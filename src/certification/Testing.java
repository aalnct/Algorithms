package certification;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.LongUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by AmitAgarwal on 1/15/20.
 */
public class Testing {
    int value = 10;
    int x;


    public Testing(int i){
        this.value = i;
    }

    private AtomicInteger atomicInteger = new AtomicInteger(value);

    public static void main(String [] args) throws IOException{

        LongUnaryOperator lou = l -> l*2;
        long l = lou.compose(lou).applyAsLong(3);
        System.out.println(l);

        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRANCE);
        System.out.println(df.getNumberFormat());


        DateFormat df1 = DateFormat.getDateInstance(DateFormat.LONG,new Locale("fr"));
        System.out.println(df1.getTimeZone());



        Testing test = new Testing(5);
        System.out.println(test.atomicInteger.decrementAndGet());

        LocalDate ld0 = LocalDate.of(2012,12,31);
        LocalDate ld1 = LocalDate.ofYearDay(2012,365);
        System.out.println(ld0.equals(ld1));


        System.out.println(LocalTime.ofSecondOfDay(36000));

        LocalDate today = LocalDate.parse("2016-01-26");
        Period days = Period.ofDays(7);
        today.plus(days);
        System.out.println(today); //since LocalDate instance are immutable, so the value returned will be same

        byte [] b = new byte[10];
        InputStream in = System.in;
        int i = in.read(b);

        for(byte c : b){
            System.out.println((char)c);
        }

        in.close();

        Stream<String> stream = Stream.of("Cat","Dog","Rat");
        Stream<Integer> list = stream.flatMap(s -> Stream.of(s.length()));
        System.out.println(list.collect(Collectors.toSet()));
    }
}
