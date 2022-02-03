package string.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import static java.lang.System.out;

public class Task12 {
    private static final Random random = new Random();

    public static void main(String[] args) {
        out.println("Час роботи для ArrayList");
        testArrayListOperationsTime(10000);
        out.println("Час роботи для LinkedLst");
        testLinkedListOperationsTime(10000);
    }
    private static void testArrayListOperationsTime(int numbers) {
        ArrayList<Double> arrayList = new ArrayList<>();
        //ініціалізація
        for (int i = 0; i < numbers; i++)
            arrayList.add(random.nextDouble());
        out.print("Початок масву   - ");
        getArrayListOperationsTime(arrayList, numbers, 0);
        out.print("Середина масиву - ");
        getArrayListOperationsTime(arrayList, numbers, (arrayList.size() - 1) / 2);
        out.print("Кінець масиву   - ");
        getArrayListOperationsTime(arrayList, numbers, arrayList.size());
    }

    public static void testLinkedListOperationsTime(int numbers) {
        LinkedList<Double> linkedList = new LinkedList<>();
        //ініціалізація
        for (int i = 0; i < numbers; i++)
            linkedList.add(random.nextDouble());
        out.print("Початок колекції  - ");
        getlinkedListOperationsTime(linkedList, numbers, -1);
        out.print("Середина колекції - ");
        getlinkedListOperationsTime(linkedList, numbers, 0);
        out.print("Кінець колекції   - ");
        getlinkedListOperationsTime(linkedList, numbers, 1);
    }

    private static void getArrayListOperationsTime(ArrayList<Double> arrayList, int numbers, int index) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < numbers; i++) {
            arrayList.add(index, random.nextDouble());
        }
        out.print("\tAdd: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        for (int i = 0; i < numbers; i++) {
            arrayList.set(index, random.nextDouble());
        }
        out.print("\tSet: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        for (int i = 0; i < numbers; i++) {
            arrayList.remove(index);
        }
        out.println("\tRemove: "  + (System.currentTimeMillis() - start));
    }

    private static void getlinkedListOperationsTime(LinkedList<Double> linkedList, int numbers, int index) {
        long start;
        switch (index) {
            case -1: {
                start = System.currentTimeMillis();
                for (int i = 0; i < numbers; i++) {
                    linkedList.addFirst(random.nextDouble());
                }
                out.print("\tAdd: " + (System.currentTimeMillis() - start));
                start = System.currentTimeMillis();
                for (int i = 0; i < numbers; i++) {
                    linkedList.set(0, random.nextDouble());
                }
                out.print("\tSet: " + (System.currentTimeMillis() - start));
                start = System.currentTimeMillis();
                for (int i = 0; i < numbers; i++) {
                    linkedList.pollFirst();
                }
                out.println("\tRemove: " + (System.currentTimeMillis() - start));
                break;
            }
            case 0: {
                start = System.currentTimeMillis();
                for (int i = 0; i < numbers; i++) {
                    linkedList.add(linkedList.size() / 2, random.nextDouble());
                }
                out.print("\tAdd: " + (System.currentTimeMillis() - start));
                start = System.currentTimeMillis();
                for (int i = 0; i < numbers; i++) {
                    linkedList.set((linkedList.size() - 1) / 2, random.nextDouble());
                }
                out.print("\tSet: " + (System.currentTimeMillis() - start));
                start = System.currentTimeMillis();
                for (int i = 0; i < numbers; i++) {
                    linkedList.remove(linkedList.size() / 2);
                }
                out.println("\tRemove: " + (System.currentTimeMillis() - start));
                break;
            }
            case 1: {
                start = System.currentTimeMillis();
                for (int i = 0; i < numbers; i++) {
                    linkedList.addLast(random.nextDouble());
                }
                out.print("\tAdd: " + (System.currentTimeMillis() - start));
                start = System.currentTimeMillis();
                for (int i = 0; i < numbers; i++) {
                    linkedList.set(linkedList.size() - 1, random.nextDouble());
                }
                out.print("\tSet: " + (System.currentTimeMillis() - start));
                start = System.currentTimeMillis();
                for (int i = 0; i < numbers; i++) {
                    linkedList.pollLast();
                }
                out.println("\tRemove: " + (System.currentTimeMillis() - start));
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + index);
        }
    }

}