package aggregateOperations;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
import static java.util.List.*;

public class Task18 {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.addAll(of("string/collections", "store", "", "most", "message", "", "application", "", "criteria"));
        arrayList.stream()
                .filter(element -> !element.isEmpty())
                .forEach(element -> out.print(element + ", "));
    }

}
