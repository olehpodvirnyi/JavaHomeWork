package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

public class Task_3 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 5, 5, 7, 5, 6, 6, 1, 9, 9, 9, 9, 9};
        List<Integer> delet_element = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        // Створення масиву елементів які потрібно видалити
        Arrays.sort(array);
        int count = 1;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                count++;
                if (count > 2 && !delet_element.contains(array[i]))
                        delet_element.add(array[i]);
            } else {
                count = 1;
            }
        }

        //Резольтуючий масив
        for (int j : array)
            if (!delet_element.contains(j))
                result.add(j);

        out.print("\nResult: ");
        result.forEach(number -> out.print(number + " "));
    }
}
