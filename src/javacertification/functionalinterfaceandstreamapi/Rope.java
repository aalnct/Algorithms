package javacertification.functionalinterfaceandstreamapi;

public class Rope {
    int length;
    String color;

    Rope (int length, String color) {
        this.color = color;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Rope{" +
                "length=" + length +
                ", color='" + color + '\'' +
                '}';
    }

    static class Ropefilter {
        boolean filter (Rope rope) {
            return rope.color.equalsIgnoreCase("Red");
        }
    }
}
