package valeri.java8;

/**
 * Created by saranv2 on 07/07/2017.
 */
public class Apple {
    private int weight = 0;
    private String color = "";

    public Apple(int weight, String color){
        this.weight = weight;
        this.color = color;
    }
    public int getWeight() {
        return weight;
    }
    public String getColor() {
        return color;
    }

    public Orange toOrange() {
        return new Orange(this.weight, this.color);
    }

    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
