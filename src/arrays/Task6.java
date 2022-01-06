package arrays;

import java.util.Scanner;

import static java.lang.System.out;

public class Task6 {
    public static void print(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++)
                out.print(ints[j] + " ");
            out.print("\n");
        }
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

    public static int[][] createMatrix() {
        out.print("Enter the rows in the matrix: ");
        Scanner console = new Scanner(System.in);
        int row = console.nextInt();
        out.print("Enter the columns in the matrix: ");
        int column = console.nextInt();

        int[][] matrix = new int[row][column];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                out.print("Enter matrix[" + (i + 1) + "][" + (j + 1) + "] = ");
                matrix[i][j] = console.nextInt();
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = createMatrix();

        out.println("Matrix:");
        print(matrix);

        out.print("MAX = " + maxElement(matrix));
    }
}