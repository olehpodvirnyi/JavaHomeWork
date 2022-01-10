package collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.lang.System.out;

public class Task16 {
    public static void main(String[] args) {
        Map<Integer, String> person = new HashMap<>();
        person.put(148752, "Percy Jackson");
        person.put(274162, "Luca Patterson");
        person.put(745161, "Usman Carter");
        person.put(746516, "Griffin Patter");

        person.forEach((k, v) -> out.println("Key: " + k + " Value: " + v));
        /*
        for (var entry : person.entrySet()) {
            out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
        */

        out.print("Key:");
        Set<Integer> keys = person.keySet();
        keys.forEach(element ->out.print(element +" "));

        out.print("\nValue:");
        Collection<String> values = person.values();
        values.forEach(element ->out.print(element +" "));

        person.put(123464,"Cannon Price");
        person.replace(123464, "Leighton Carter");
        person.remove(2);

    }
}
