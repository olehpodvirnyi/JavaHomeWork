package string;

import java.util.Scanner;

import static java.lang.System.out;

public class Task8 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        out.print("Enter your line: ");
        String[] str = console.nextLine().split(" ");

        StringBuffer strBuffer = new StringBuffer();

        strBuffer.append(str[str.length - 1].toLowerCase());
        strBuffer.setCharAt(0, Character.toUpperCase(strBuffer.charAt(0)));
        for (int i = str.length - 2; i >= 0; i--) {
            strBuffer.append(" " + str[i].toLowerCase());
        }

        out.print("The resulting string: " + strBuffer);
    }
}
