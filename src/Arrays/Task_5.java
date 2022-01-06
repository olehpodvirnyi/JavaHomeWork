package Arrays;

import java.util.Scanner;

import static java.lang.System.out;

public class Task_5 {
    public static int[][] transpose(int[][] matrix) {
        int[][] t_matr = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix[0].length; i++)
            for (int j = 0; j < matrix.length; j++)
                t_matr[i][j] = matrix[j][i];
        return t_matr;
    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.print("\n");
        }
    }

    public static int[][] create_matrix() {
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
        int[][] matrix = create_matrix();

        out.println("Matrix:");
        print(matrix);

        out.println("Transpose matrix:");
        print(transpose(matrix));
    }
}
