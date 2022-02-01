package internationalization;

import java.nio.charset.StandardCharsets;

import static java.lang.System.out;

public class Task24 {
    public static void main(String[] args) {
        String text = "The façade pattern is a software design pattern.”";

        out.println("US_ASCII -> UTF_8   :  " + new String(text.getBytes(StandardCharsets.US_ASCII), StandardCharsets.UTF_8));
        out.println("US_ASCII -> UTF_16  :  " + new String(text.getBytes(StandardCharsets.US_ASCII), StandardCharsets.UTF_16));
        out.println("US_ASCII -> US_ASCII:  " + new String(text.getBytes(StandardCharsets.US_ASCII), StandardCharsets.US_ASCII));

        out.println("\nUTF_8 -> UTF_8   :  " + new String(text.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8));
        out.println("UTF_8 -> UTF_16  :  " + new String(text.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_16));
        out.println("UTF_8 -> US_ASCII:  " + new String(text.getBytes(StandardCharsets.UTF_8), StandardCharsets.US_ASCII));

        out.println("\nUTF_16 -> UTF_8   :  " + new String(text.getBytes(StandardCharsets.UTF_16), StandardCharsets.UTF_8));
        out.println("UTF_16 -> UTF_16  :  " + new String(text.getBytes(StandardCharsets.UTF_16), StandardCharsets.UTF_16));
        out.println("UTF_16 -> US_ASCII:  " + new String(text.getBytes(StandardCharsets.UTF_16), StandardCharsets.US_ASCII));
    }

}