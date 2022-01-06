package Arrays;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

public class Task_1 {
    public static int get_k(Scanner console) {
        out.print("Enter k: ");
        return console.nextInt();
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        out.print("Enter the length of the array: ");
        int[] array = new int[console.nextInt()];

        int k = get_k(console);
        while (k <= 0 || k > array.length) {
            out.println("ERROR (k<0 or k>= array_length) !!!");
            k = get_k(console);
        }

        for (int i = 0; i < array.length; i++) {
            out.print("Element[" + (i + 1) + "] = ");
            array[i] = console.nextInt();
        }

        Arrays.sort(array);

        out.println("\nk_min = " + array[k - 1]);
        out.println("k_max = " + array[array.length - k]);
    }
}
