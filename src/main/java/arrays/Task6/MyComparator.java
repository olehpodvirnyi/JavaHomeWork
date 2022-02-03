package arrays.Task6;

import java.util.List;

public class MyComparator {
    public int compare(List<Integer> integers, List<Integer> integers1) {
        int maxFirst = integers.stream()
                .max(Integer::compare).orElse(0);
        int maxSecond = integers1.stream()
                .max(Integer::compare).orElse(0);
        return Integer.compare(maxFirst, maxSecond);
    }
}
