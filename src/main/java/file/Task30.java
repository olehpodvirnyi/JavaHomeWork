package file;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static java.lang.System.out;

public class Task30 {

    public static void main(String[] args) throws IOException {
        //вибираємо унікальні слова з тексту та записуємо їх в файл
        String text = Files.readString(Paths.get("src\\main\\java\\file\\text.txt"));
        FileWriter nFile = new FileWriter("src\\main\\java\\file\\rez.txt");
        Arrays.stream(text.split("[^a-zA-Z]"))
                .map(String::toLowerCase)
                .distinct()
                .filter(element->element.length()>2)
                .forEach(str -> {
                    out.println(str);
                    try {
                        nFile.write(str+"\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        nFile.close();
    }
}
