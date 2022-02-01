package arrays;

import arrays.Task1.Task1;
import arrays.Task2.Task2;
import arrays.Task3.Task3;
import arrays.Task4.Task4;
import arrays.Task5.Task5;
import arrays.Task6.Task6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) throws Exception {
        List<Integer> integerListFirst = Stream.of(1, 5, 5, 5, 7, 5, 6, 6, 1, 9, 9, 9, 9, 9).collect(toList());
        List<Integer> integerListSecond = Stream.of(5, 6, 7, 8, 9, 10).collect(toList());
        List<List<Integer>> matrix = createMatrix(5, 5);
        List<Object> objects = new ArrayList<>(List.of(
                new Task1(),
                new Task2(),
                new Task3(),
                new Task4(),
                new Task5(),
                new Task6()
        ));/*
        ((Task1) objects.get(0)).testTask1();
        ((Task2) objects.get(1)).testTask2();
        ((Task3) objects.get(2)).testTask3();
        ((Task4) objects.get(3)).testTask4();
        ((Task5) objects.get(4)).testTask5(matrix);
        ((Task6) objects.get(5)).testTask6();*/

        //Using Stream API
        //((Task1) objects.get(0)).testTaskStreamAPI1(integerListFirst, 1);
        ((Task2) objects.get(1)).testTaskStreamAPI2(integerListFirst, integerListSecond);
        //((Task3) objects.get(2)).testTaskStreamAPI3(integerListFirst);
       // ((Task4) objects.get(3)).testTaskStreamAPI4(integerListFirst);
       // ((Task5) objects.get(4)).testTaskStreamAPI5(matrix);
       // ((Task6) objects.get(5)).testTaskStreamAPI6(matrix);
    }

    public static List<List<Integer>> createMatrix(Integer row, Integer column) {
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<Integer> tempLine = new ArrayList<>();
            for (int j = 0; j < column; j++) {
                tempLine.add(random.nextInt(10));
            }
            matrix.add(tempLine);
        }
        return matrix;
    }

}