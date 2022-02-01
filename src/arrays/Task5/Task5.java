package arrays.Task5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class Task5 {

    public void testTask5(List<List<Integer>> matrix) {
        out.println("~~~~~~~~~Task5~~~~~~~~~");
        out.println("Matrix:");
        print(matrix);
        out.println("Transpose matrix:");
        print(transpose(matrix));
    }

    public void testTaskStreamAPI5(List<List<Integer>> matrix) {
        out.println("~~~~~~~~~Task5 Stream API~~~~~~~~~");
        out.println("Matrix:");
        print(matrix);
        out.println("Transpose matrix:");
        print(transposeStreamAPI(matrix));
    }

    private static List<List<Integer>> transpose(List<List<Integer>> matrix) {
        List<List<Integer>> rez = new ArrayList<>();
        for (int i = 0; i < matrix.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < matrix.get(0).size(); j++) {
                temp.add(matrix.get(j).get(i));
            }
            rez.add(temp);
        }
        return rez;
    }

    private static List<List<Integer>> transposeStreamAPI(List<List<Integer>> matrix) {
        List<List<Integer>> rez = new ArrayList<>();
        IntStream.range(0, matrix.get(0).size())
                .forEach(index -> {
                    List<Integer> temp = new ArrayList<>();
                    matrix.stream()
                            .mapToInt(element -> element.get(index))
                            .forEach(temp::add);
                    rez.add(temp);
                });
        return rez;
    }

    private static void print(List<List<Integer>> matrix) {
        matrix
                .forEach(line -> {
                    line
                            .forEach(number -> out.printf("%-5s", number));
                    out.println();
                });
    }
}
