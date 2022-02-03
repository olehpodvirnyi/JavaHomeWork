package arrays.Task6;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Task6 {
    public void testTask6(){
        out.println("~~~~~~~~~Task6~~~~~~~~~");
        int[][] matrix = createMatrix();
        out.println("Matrix:");
        print(matrix);
        out.print("MAX = " + maxElement(matrix));
        out.println();
    }

    public void testTaskStreamAPI6(List<List<Integer>> matrix) {
        out.println("~~~~~~~~~Task6 Stream API~~~~~~~~~");
        out.println("Matrix:");
        print(matrix);
        MyComparator myComparator = new MyComparator();
        int max = matrix.stream()
                .max(myComparator::compare)
                .orElseThrow()
                .stream()
                .max(Integer::compare)
                .orElseThrow();
        out.print("MAX = " + max);
    }

    private static void print(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++)
                out.printf("%-5s", ints[j]);
            out.print("\n");
        }
    }

    private static void print(List<List<Integer>> matrix) {
        matrix
                .forEach(element -> {
                    element
                            .forEach(number -> out.printf("%-5s", number));
                    out.println();
                });
    }

    public static int maxElement(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (ints[j] > max)
                    max = ints[j];
            }
        }
        return max;
    }

    private static int[][] createMatrix(){
        out.print("Enter the rows in the matrix: ");
        Scanner console = new Scanner(System.in);
        int row = console.nextInt();
        out.print("Enter the columns in the matrix: ");
        int column = console.nextInt();
        try {
            if (column <= 0 || row <= 0) {
                throw new InputSizeException();
            }
        } catch (InputSizeException e) {
            out.println(e);
        }
        int[][] matrix = new int[row][column];
        for (
                int i = 0;
                i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                out.print("Enter matrix[" + (i + 1) + "][" + (j + 1) + "] = ");
                matrix[i][j] = console.nextInt();
            }
        }
        return matrix;
    }

}