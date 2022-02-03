package string.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.lang.System.out;

public class Task13 {
    private static final Random random = new Random();

    public static int getPercentageSimilarity(List<Integer> firstArrayList, List<Integer> secondArrayList) {
        Collections.sort(firstArrayList);
        Collections.sort(secondArrayList);

        int similarity = 0;
        for (int indexFirstArrayList = 0, indexSecondArrayList = 0; indexFirstArrayList < firstArrayList.size() &&
                indexSecondArrayList < secondArrayList.size(); ) {
            if (firstArrayList.get(indexFirstArrayList).equals(secondArrayList.get(indexSecondArrayList))) {
                similarity++;
                indexSecondArrayList++;
                indexFirstArrayList++;
            } else {
                if (firstArrayList.get(indexFirstArrayList) < secondArrayList.get(indexSecondArrayList))
                    indexFirstArrayList++;
                else
                    indexSecondArrayList++;
            }
        }


        return (similarity * 100) / firstArrayList.size();
    }

    public static void main(String[] args) {
        ArrayList<Integer> firstArrayList = new ArrayList<>();
        ArrayList<Integer> secondArrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            firstArrayList.add(random.nextInt(100));
            secondArrayList.add(random.nextInt(100));
        }
        if (firstArrayList.equals(secondArrayList)) {
            out.println("firstArrayList == secondArrayList");
        } else {
            out.println("Percentage of similarity " + getPercentageSimilarity(firstArrayList, secondArrayList) + "%");
        }
    }

}
