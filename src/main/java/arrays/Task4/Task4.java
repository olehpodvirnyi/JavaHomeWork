package arrays.Task4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.out;

public class Task4 {

    public void testTask4() {
        out.println("~~~~~~~~~Task4~~~~~~~~~");
        List<Integer> array = new ArrayList<>(List.of(1, 5, 5, 5, 7, 5, 6, 6, 1, 9, 9, 9, 9, 9));
        out.print("The initial mass:");
        array
                .forEach(number -> out.print(number + " "));
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i - 1).equals(array.get(i))) {
                array.remove(array.get(i));
                i--;
            }
        }
        out.print("\nResult: ");
        array
                .forEach(number -> out.print(number + " "));
        out.println();
    }

    public void testTaskStreamAPI4(List<Integer> integerListFirst) {
        out.println("~~~~~~~~~Task4 Stream API~~~~~~~~~");
        out.print("MyList (Before) = ");
        integerListFirst
                .forEach(element -> out.print(element + " "));
        out.print("\nMyList (After) = ");
        LinkedList<Integer> linkedList = new LinkedList<>();
        integerListFirst.stream()
                .filter(element -> linkedList.isEmpty() || !linkedList.getLast().equals(element))
                .forEach(linkedList::add);
        linkedList
                .forEach(element -> out.print(element + " "));
        out.println();
    }

}