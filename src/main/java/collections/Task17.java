package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class Task17 {
    public static void main(String[] args) {
        Map<String, List<String>> books = new HashMap<>();
        books.put("Percy Jackson", List.of("Whispers of Time", "Bridgital Nation"));
        books.put("Luca Patterson", List.of("Whispers of Time", "Darkness to light"));
        books.put("Usman Carter", List.of("Bridgital Nation", "The Diary of Manu Gandhi"));
        books.put("Griffin Patter", List.of("Fakir Hassen", "Vivekadeepini"));
        books.put("Baba Ramdev", List.of("Manav", "Whispers of Time"));
        books.put("Persistent Systems", List.of("Manav", "Saffron Swords"));
        Map<String, List<String>> result = new HashMap<>();
        for (var selectedAuthor : books.keySet())
            for (var book : books.get(selectedAuthor)) {
                List<String> anotherAuthor = result.put(book, List.of(selectedAuthor));
                if (anotherAuthor != null) {
                    List<String> tempAutors = new ArrayList<>(anotherAuthor);
                    tempAutors.add(selectedAuthor);
                    result.put(book, tempAutors);
                }
            }
        result.forEach((k, v) -> {
            out.print("\nBook: " + k + "\nAuthors: ");
            for (var el : v) {
                out.print(el + ", ");
            }
        });
    }

}