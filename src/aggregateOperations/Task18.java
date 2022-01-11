package aggregateOperations;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Task18 {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("collections");
        arrayList.add("store ");
        arrayList.add("");
        arrayList.add("most");
        arrayList.add("message");
        arrayList.add("");
        arrayList.add("application ");
        arrayList.add("");
        arrayList.add("criteria");

        List<String> result = new ArrayList<>();
        arrayList.stream().filter(element-> !element.isEmpty()).forEach(result::add);
        result.forEach(element->out.print(element +", "));
    }
}
