package string.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.lang.System.out;

public class Task14 {
    private static final Random random = new Random();

    public static List<Integer> unification(List<Integer> firstArrayList, List<Integer> secondArrayList) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < firstArrayList.size(); i++) {
            result.add(firstArrayList.get(i));
            result.add(secondArrayList.get(i));
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> firstArrayList = new ArrayList<>();
        ArrayList<Integer> secondArrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            firstArrayList.add(random.nextInt(100));
            secondArrayList.add(random.nextInt(100));
        }
        out.print("First List: ");
        firstArrayList.forEach(number -> out.print(number + " "));
        out.print("\nSecond List: ");
        secondArrayList.forEach(number -> out.print(number + " "));
        out.print("\nUnification List: ");
        unification(firstArrayList, secondArrayList).forEach(number -> out.print(number + " "));
    }

}