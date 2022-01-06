package arrays;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Task4 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 1, 1, 5, 5, 6, 9, 5, 7, 5, 6, 6, 1, 9, 9, 9, 9, 9};

        List<Integer> result = new ArrayList<>();
        result.add(array[0]);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1])
                result.add(array[i + 1]);
        }

        result.forEach(number -> out.print(number + " "));
    }
}
