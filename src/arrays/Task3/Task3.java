package arrays.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Task3 {
    public void testTask3() {
        out.println("~~~~~~~~~Task3~~~~~~~~~");
        List<Integer> array = new ArrayList<>(List.of(1, 5, 5, 5, 7, 5, 6, 6, 1, 9, 9, 9, 9, 9));
        out.print("The initial mass:");
        array.forEach(number -> out.print(number + " "));
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer k : array) {
            if (map.containsKey(k)) {
                map.replace(k, map.get(k) + 1);
            } else {
                map.put(k, 1);
            }
        }
        for (Entry<? extends Integer, ? extends Integer> k : map.entrySet()) {
            if (k.getValue() > 2) {
                while (array.contains(k.getKey())) {
                    array.remove(k.getKey());
                }
            }
        }
        out.print("\nResult: ");
        array.forEach(number -> out.print(number + " "));
        out.println();
    }

    public void testTaskStreamAPI3(List<Integer> array) {
        out.println("~~~~~~~~~Task3 Stream API~~~~~~~~~");
        out.print("The initial mass:");
        array.forEach(number -> out.print(number + " "));
        out.print("\nResult: ");
        List<Integer> rez = new ArrayList<>(array);
        rez.removeAll(array.stream().collect(
                        Collectors.groupingBy(element -> element, Collectors.counting())).entrySet().stream().
                filter(entry -> entry.getValue() > 2)
                .map(Entry::getKey)
                .collect(Collectors.toList()));
        rez.forEach(number -> out.print(number + " "));
        out.println();
    }

}
