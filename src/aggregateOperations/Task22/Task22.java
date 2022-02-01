package aggregateOperations.Task22;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static java.util.List.of;

public class Task22 {

    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>(of(
                new Fruit("lemon", true),
                new Fruit("lime", true),
                new Fruit("orange", true),
                new Fruit("pear", false),
                new Fruit("melon", false),
                new Fruit("apple", false)
        ));
        of(new Fruit("plum", false), new Fruit("apple", false)).forEach(fruits::add);
        out.println("\tAll Fruits");
        fruits.forEach(Fruit::display);
        out.println("\tCitrus Fruits");
        fruits.stream()
                .distinct()
                .filter(Fruit::isCitrus)
                .collect(Collectors.toList())
                .forEach(Fruit::display);
    }

}