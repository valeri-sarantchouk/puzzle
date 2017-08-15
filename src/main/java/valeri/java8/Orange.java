package valeri.java8;

/**
 * Created by SARANV2 on 13/07/2017.
 */
public class Orange {
    private int weight = 0;
    private String color = "";

    public Orange(int weight, String color){
        this.weight = weight;
        this.color = color;
    }
    public int getWeight() {
        return weight;
    }
    public String getColor() {
        return color;
    }
    public String toString() {
        return "Orange{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
