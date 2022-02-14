package machineLearning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;
import static java.util.List.of;

public class Task31 {
    static final Integer USER = 50;
    static final Integer GOODS = 8;
    static final Integer NEED = 4;
    static final List<List<Integer>> t = new ArrayList<>(of(
            of(1, 2, 3, 4, 5, 10, 11, 12, 15, 17, 18, 20, 21, 22, 26, 27, 28, 30, 31, 32, 34, 36, 37, 40, 43, 44, 46, 47, 49),
            of(2, 5, 6, 7, 9, 10, 13, 14, 15, 17, 19, 21, 24, 26, 32, 34, 36, 38, 45, 47, 48, 50),
            of(2, 5, 6, 9, 11, 12, 14, 15, 16, 20, 21, 24, 26, 32, 34, 38, 45, 47, 48, 50),
            of(3, 4, 5, 10, 11, 12, 15, 17, 18, 20, 21, 22, 26, 27, 28, 30, 31, 32, 34, 36, 37, 40, 43, 44, 46, 49),
            of(1, 2, 6, 7, 8, 9, 13, 14, 15, 17, 18, 20, 23, 24, 25, 26, 28, 29, 33, 35, 38, 39, 41, 42, 45, 47, 48, 50),
            of(2, 3, 7, 8, 9, 13, 14, 15, 17, 18, 20, 22, 23, 24, 25, 27, 29, 31, 33, 34, 35, 38, 39, 41, 42, 45, 47, 48, 50),
            of(2, 5, 6, 10, 11, 12, 15, 17, 18, 20, 21, 22, 24, 26, 32, 34, 36, 37, 45, 47, 48, 50),
            of(1, 3, 4, 6, 7, 9, 10, 12, 15, 17, 18, 20, 21, 22, 26, 27, 28, 30, 31, 32, 34, 36, 37, 40, 43, 44, 46, 49)));

    private static int[][] crateMatrix() {
        int[][] arr = new int[USER][GOODS];
        for (int i = 0; i < USER; i++) {
            for (int j = 0; j < GOODS; j++) {
                arr[i][j] = 0;
            }
        }
        return arr;
    }

    private static void inputMatrix(int[][] arr, int line, List<? extends Integer> t) {
        for (int element : t) {
            arr[element - 1][line] = 1;
        }
    }

    public static void print2D(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            out.print("User" + (i + 1) + '\t');
            for (int j = 0; j < mat[i].length; j++)
                out.print(mat[i][j] + "  ");
            out.println();
        }
    }

    private static List<Double> getCosArr(int[][] mat, int row) {
        List<Double> rez = new ArrayList<>();
        for (int i = 0; i < GOODS; i++) {
            rez.add(similarity(getRow(mat, row), getRow(mat, i)));
        }
        return rez;
    }

    private static List<Integer> getRow(int[][] mat, int row) {
        List<Integer> rez = new ArrayList<>();
        for (int i = 0; i < USER; i++) {
            rez.add(mat[i][row]);
        }
        return rez;
    }


    private static double similarity(List<Integer> vectorA, List<Integer> vectorB) {
        if (vectorA.equals(vectorB)) {
            return 1;
        } else {
            return scalarProduct(vectorA, vectorB) / (norm(vectorA) * norm(vectorB));
        }
    }

    private static double norm(List<Integer> vector) {
        int rez = 0;
        for (Integer integer : vector) {
            rez += Math.pow(integer, 2);
        }
        return Math.sqrt(rez);
    }

    private static double scalarProduct(List<Integer> vectorA, List<Integer> vectorB) {
        int rez = 0;
        for (int i = 0; i < vectorA.size(); i++) {
            rez += vectorA.get(i) * vectorB.get(i);
        }
        return rez;
    }

    public static void main(String[] args) {
        int[][] matrix = crateMatrix();
        for (int i = 0; i < t.size(); i++) {
            inputMatrix(matrix, i, t.get(i));
        }
        out.println("Goods\t1  2  3  4  5  6  7  8");
        out.println("-----------------------------");
        print2D(matrix);
        Map<Integer, List<Double>> rezult = new HashMap<>();
        for (int i = 0; i < GOODS; i++) {
            rezult.put(i, getCosArr(matrix, i));
        }
        for (int i = 0; i < GOODS; i++) {
            out.println("GOODS " + NEED + " ~ GOODS " + (i + 1) + " = " + rezult.get(NEED - 1).get(i));
        }
    }
}