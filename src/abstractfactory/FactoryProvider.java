package abstractfactory;

public class FactoryProvider {

    public static AbstractFactory getFactory (String choice) {
        if ("Animal".equalsIgnoreCase(choice)) {
            return new AnimalFactory ();
        } else if ("color".equalsIgnoreCase(choice)) {
            return new ColorFactory();
        }
        return null;
    }
}
