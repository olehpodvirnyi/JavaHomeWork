package aggregateOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Task22 {
    static class Fruit {
        private String name;
        private boolean citrus;

        Fruit(String name, boolean citrus) {
            this.name = name;
            this.citrus = citrus;
        }

        public boolean isCitrus() {
            return citrus;
        }

        public void display() {
            System.out.println(name + "\t, citrus: " + isCitrus());
        }
    }


    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("lemon", true));
        fruits.add(new Fruit("lime", true));
        fruits.add(new Fruit("orange", true));
        fruits.add(new Fruit("pear", false));
        fruits.add(new Fruit("melon", false));
        fruits.add(new Fruit("apple", false));

        List.of(new Fruit("plum", false), new Fruit("apple", false)).forEach(fruits::add);

        out.println("\tAll Fruits");
        fruits.forEach(Fruit::display);

        List<Fruit> citrusFruits = fruits.stream()
                .distinct()
                .filter(Fruit::isCitrus)
                .collect(Collectors.toList());
        out.println("\tCitrus Fruits");
        citrusFruits.forEach(Fruit::display);
    }

}
