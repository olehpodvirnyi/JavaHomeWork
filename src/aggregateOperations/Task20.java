package aggregateOperations;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Task20 {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i + 1);
        }
        arrayList.stream()
                .map(element -> element * 3)
                .filter(element -> element % 2 != 0)
                .forEach(element -> out.print(element + " "));
    }
}
