package aggregateOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Task23 {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        Scanner console = new Scanner(System.in);
        String inputString;
        out.println("Enter text:");
        do {
            inputString = console.nextLine();
            Arrays.stream(inputString.split(" "))
                    .map(word -> word.replaceAll("[^A-Za-z]", ""))
                    .filter(word -> !word.isEmpty() && !word.equals(" "))
                    .forEach(words::add);
        } while (!inputString.isEmpty());
        out.println("Number of unique words: " + words.stream().distinct().count());
        out.println("\nAll unique words are sorted:");
        words.stream()
                .distinct()
                .sorted()
                .forEach(word -> out.print(word + " "));
        out.println("\n\nThe number of each word:");
        words.stream()
                .distinct()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .forEach((k, v) -> out.print(k + "\t-\t" + v + "\n"));
        long tempNumber = words.stream()
                .collect(Collectors.joining())
                .chars()
                .filter(element -> element >= 98 && element <= 122)
                .count();
        out.println("\nNumber of all characters except uppercase characters: " + tempNumber);
    }

}