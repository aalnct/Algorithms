package javacertification.functionalinterfaceandstreamapi;

public class TrafficLight {
    String message;
    Color color;

    TrafficLight (String message, Color color) {
        this.color = color;
        this.message = message;
    }

    public String getMessage () {
        return this.message;
    }

    public Color getColor () {
        return this.color;
    }

    @Override
    public String toString() {
        return "TrafficLight{" +
                "message='" + message + '\'' +
                ", color=" + color +
                '}';
    }
}
