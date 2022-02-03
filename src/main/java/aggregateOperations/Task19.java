package aggregateOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.System.out;

public class Task19 {
    private static final Random random = new Random();

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(random.nextInt(100));
        }

        //Конвейерные — возвращают другой stream, то есть работают как builder,
        out.println("\tIntermediate opperations");
        arrayList.stream()
                .skip(10)
                .filter(element -> element % 2 == 0)
                .distinct()
                .map(element -> element * 2)
                .forEach(element -> out.print(element + " "));
        out.println("\n\n\tTerminal operations");

        //Терминальные — возвращают другой объект, такой как коллекция, примитивы, объекты, Optional и т.д.
        out.println("FindFirst : " + arrayList.stream()
                .findFirst()
                .orElse(1));
        out.println("FindAny : " + arrayList.stream()
                .findAny()
                .orElse(1));
        out.println("Count : " + arrayList.stream().count());
        out.println("Sum : " + arrayList.stream()
                .reduce(Integer::sum)
                .orElse(0));
    }
}
