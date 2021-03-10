package abstractfactory;

public class ColorFactory implements AbstractFactory<Color>{

    @Override
    public Color create(String type) {
        if ("black".equalsIgnoreCase(type)) {
            return new Black();
        } else if ("white".equalsIgnoreCase(type)) {
            return new White();
        }
        return null;
    }
}
