package arrays;

import java.util.Scanner;

import static java.lang.System.out;

public class Task5 {
    public static int[][] transpose(int[][] matrix) {
        int[][] tMatr = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix[0].length; i++)
            for (int j = 0; j < matrix.length; j++)
                tMatr[i][j] = matrix[j][i];
        return tMatr;
    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                out.print(matrix[i][j] + " ");
            out.print("\n");
        }
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

        out.println("Transpose matrix:");
        print(transpose(matrix));
    }
}
