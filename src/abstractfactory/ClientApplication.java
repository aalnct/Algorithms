package abstractfactory;

public class ClientApplication {
    /**
     *
     * @param args
     *
     * Abstract factory design will hide the implementation from the client and provide the factory methods
     * to create the objects and return the results
     */
    public static void main(String[] args) {
        AbstractFactory<Animal> abstractFactory = FactoryProvider.getFactory("animal");
        if (abstractFactory != null)
        System.out.println(abstractFactory.create("tiger"));
    }
}
