package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import static java.lang.System.out;

public class Task12 {
    private static final Random random = new Random();

    public static long testArrayListOperationsTime(int numbers) {
        ArrayList<Double> arrayList = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < numbers; i++) {
            arrayList.add(random.nextDouble());
        }
        arrayList.add(0, 1.0);
        arrayList.set(0, 2.0);
        arrayList.remove(0);

        arrayList.add(arrayList.size() / 2, 1.0);
        arrayList.set((arrayList.size() - 1) / 2, 2.0);
        arrayList.remove(arrayList.size() / 2);

        arrayList.add(arrayList.size(), 1.0);
        arrayList.set(arrayList.size() - 1, 2.0);
        arrayList.remove(arrayList.size() - 1);
        return System.currentTimeMillis() - start;
    }

    public static long testLinkedListOperationsTime(int numbers) {
        LinkedList<Double> linkedList = new LinkedList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < numbers; i++)
            linkedList.add(random.nextDouble());
        linkedList.addFirst(1.0);
        linkedList.set(0, 2.0);
        linkedList.pollFirst();

        linkedList.add(linkedList.size() / 2, 1.0);
        linkedList.set((linkedList.size() - 1) / 2, 2.0);
        linkedList.remove(linkedList.size() / 2);

        linkedList.addLast(1.0);
        linkedList.set(linkedList.size() - 1, 2.0);
        linkedList.pollLast();

        return System.currentTimeMillis() - start;
    }

    public static void main(String[] args) {
        out.println("Час роботи для ArrayList (10 000 елементів) = " + testArrayListOperationsTime(10000));
        out.println("Час роботи для LinkedLst (10 000 елементів) = " + testLinkedListOperationsTime(10000));
        out.println("Час роботи для ArrayList (10 000 000 елементів) = " + testArrayListOperationsTime(10000000));
        out.println("Час роботи для LinkedLst (10 000 000 елементів) = " + testLinkedListOperationsTime(10000000));

        //Якщо в програмі частіше відбуваються операції вставки/видалення LinkedList повинен працювати швидше ArrayList.
        //У мене це не так((
    }
}
