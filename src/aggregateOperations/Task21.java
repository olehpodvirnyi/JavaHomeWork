package aggregateOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.System.out;

public class Task21 {
    private static final Random random = new Random();

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(random.nextInt(100));
        }
        arrayList.forEach(number -> out.print(number + " "));
        out.println("\nMIN: " + arrayList.stream().mapToInt(Integer::intValue).min().getAsInt());
        out.println("MAX: " + arrayList.stream().mapToInt(Integer::intValue).max().getAsInt());
        out.println("SUM: " + arrayList.stream().mapToInt(Integer::intValue).sum());
        out.println("Average: " + arrayList.stream().mapToInt(Integer::intValue).average().getAsDouble());
    }

}