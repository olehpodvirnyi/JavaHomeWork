package arrays.Task1;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;
import static java.util.Arrays.sort;

public class Task1 {
    private static final Scanner console = new Scanner(System.in);

    private static int getK() {
        out.print("Enter k: ");
        return Task1.console.nextInt();
    }

    public void testTask1() {
        out.println("~~~~~~~~~Task1~~~~~~~~~");
        int[] array;
        int k;
        try {
            out.print("Enter the length of the array: ");
            int temp = console.nextInt();
            if (temp <= 0) {
                throw new InputArraySizeException();
            }
            array = new int[temp];
            k = getK();
            if (k <= 0 || k > array.length) {
                throw new InputSetKExeptions();
            }
        } catch (InputArraySizeException | InputSetKExeptions e) {
            out.println(e);
            return;
        }
        for (int i = 0; i < array.length; i++) {
            out.print("Element[" + (i + 1) + "] = ");
            array[i] = console.nextInt();
        }
        sort(array);
        out.println("\nk_min = " + array[k - 1]);
        out.println("k_max = " + array[array.length - k]);
    }

    public void testTaskStreamAPI1(List<Integer> integerList, int k) {
        out.println("~~~~~~~~~Task1 Stream API~~~~~~~~~");
        try {
            if (k <= 0 || k > integerList.size() / 2) {
                throw new InputSetKExeptions();
            }
        } catch (InputSetKExeptions e) {
            out.println(e);
            return;
        }
        out.print("The initial First mass:");
        integerList
                .forEach(number -> out.print(number + " "));
        out.print("\nk_min = ");
        integerList.stream()
                .sorted()
                .skip(k)
                .limit(integerList.size() - (2L * k))
                .min(Integer::compare)
                .ifPresent(out::println);
        out.print("k_max = ");
        integerList.stream()
                .sorted()
                .skip(k)
                .limit(integerList.size() - (2L * k))
                .max(Integer::compare)
                .ifPresent(out::println);
    }

}