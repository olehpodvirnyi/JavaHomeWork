package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

public class Task2 {

    public static void main(String[] args) {
        int[] arrayFirst = new int[]{1, 5, 7, 6, 1};
        int[] arraySecond = new int[]{5, 6, 7, 8, 9, 10};

        List<Integer> crossing = new ArrayList<>();
        List<Integer> difference = new ArrayList<>();

        Arrays.sort(arrayFirst);
        Arrays.sort(arraySecond);

        for (int k : arrayFirst) {
            for (int j = 0; j < arraySecond.length; j++) {
                if (k == arraySecond[j]) {
                    crossing.add(k);
                    break;
                }
                if (j == arraySecond.length - 1)
                    difference.add(k);
            }
        }

        out.print("\nCrossing(A*B) = ");
        crossing.forEach(number -> out.print(number + " "));
        out.print("\nDifference(A/B) = ");
        difference.forEach(number -> out.print(number + " "));
    }
}
