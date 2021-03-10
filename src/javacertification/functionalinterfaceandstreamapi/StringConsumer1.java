package javacertification.functionalinterfaceandstreamapi;

import java.util.function.Consumer;

interface StringConsumer1 extends Consumer<String> {

    @Override
    public default void accept (String s) {
        System.out.println(s.toUpperCase());
    }
}
