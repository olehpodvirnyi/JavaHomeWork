package arrays.Task2;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Task2 {

    public void testTask2() {
        List<Integer> arrayFirst = new ArrayList<>(List.of(1, 5, 7, 6, 1));
        List<Integer> arraySecond = new ArrayList<>(List.of(5, 6, 7, 8, 9, 10));
        out.println("~~~~~~~~~Task2~~~~~~~~~");
        out.print("The initial First mass:");
        arrayFirst
                .forEach(number -> out.print(number + " "));
        out.print("\nThe initial Second mass:");
        arraySecond
                .forEach(number -> out.print(number + " "));
        List<Integer> crossing = new ArrayList<>();
        List<Integer> difference = new ArrayList<>();
        for (int k : arrayFirst) {
            for (Integer integer : arraySecond) {
                if (k == integer) {
                    crossing.add(k);
                }
            }
        }
        arrayFirst.removeAll(crossing);
        arraySecond.removeAll(crossing);
        difference.addAll(arrayFirst);
        difference.addAll(arraySecond);
        out.print("\nCrossing(A*B) = ");
        crossing.forEach(number -> out.print(number + " "));
        out.print("\nDifference(A/B) = ");
        difference.forEach(number -> out.print(number + " "));
        out.println();
    }

    public void testTaskStreamAPI2(List<Integer> integerListFirst, List<Integer> integerListSecond) {
        out.println("~~~~~~~~~Task2 Stream API~~~~~~~~~");
        out.print("The initial First mass:");
        integerListFirst.forEach(number -> out.print(number + " "));
        out.print("\nThe initial Second mass:");
        integerListSecond.forEach(number -> out.print(number + " "));
        List<Integer> integerListFirstCopy = new ArrayList(integerListFirst);
        List<Integer> integerListSecondCopy = new ArrayList(integerListSecond);
        List<Integer> crossing = new ArrayList();
        integerListFirstCopy.stream()
                .filter(element -> integerListSecondCopy.contains(element))
                .forEach(element -> {
                    integerListSecondCopy.remove(element);
                    crossing.add(element);
                });
        out.print("\nCrossing(A*B) = ");
        crossing.forEach(number -> out.print(number + " "));
        out.print("\nDifference(A/B) = ");
        crossing.forEach(integerListFirstCopy::remove);
        integerListFirstCopy.forEach(number -> out.print(number + " "));
        integerListSecondCopy.forEach(number -> out.print(number + " "));
        out.println();
    }

}