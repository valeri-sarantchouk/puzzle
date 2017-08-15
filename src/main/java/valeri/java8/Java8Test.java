package valeri.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by saranv2 on 07/07/2017.
 */
public class Java8Test {

    private static List<Apple> inventory = Arrays.asList(
            new Apple(80,"green"),
            new Apple(155, "green"),
            new Apple(120, "red"));

    public static void main(String...args) throws Exception {
        // inline implementation
        List<Apple> heavyApplesOldStyle = filterApples(inventory, new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 150;
            }
        });
        System.out.println(heavyApplesOldStyle);

        // named functions
        // method reference: passing a method as an argument
        List<Apple> greenApples = filterApples(inventory, Java8Test::isGreenApple);
        System.out.println(greenApples);

        // [Apple{color='green', weight=155}]
        List<Apple> heavyApples = filterApples(inventory, Java8Test::isHeavyApple);
        System.out.println(heavyApples);

        //-----------------------------------

        List<Apple> heavyApplesNewStyle = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(heavyApplesNewStyle);

        processElements(
                inventory,
                (Apple a) -> "red".equals(a.getColor()),
                (Apple a) -> a.toOrange(),
                (Orange o) -> System.out.println("a: " + o.toString())
        );

        // target type: the type of the lambda expression '() -> "done"' is Callable<T>.
        String s = invoke(() -> "done");
        System.out.println("s: " + s);
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public static <X, Y> void processElements(
            Iterable<X> items,
            Predicate<X> tester,
            Function<X, Y> mapper,
            Consumer<Y> consumer) {
        for (X item : items) {
            if (tester.test(item)) {
                Y data = mapper.apply(item);
                consumer.accept(data);
            }
        }
    }

    public static <T> T invoke(Callable<T> c) throws Exception {
        return c.call();
    }

}
