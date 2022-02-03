package string;

import java.util.Scanner;

import static java.lang.System.out;

public class Task8 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        out.print("Enter your line: ");
        String[] str = console.nextLine().split(" ");
        out.print(str[str.length - 1].substring(0, 1).toUpperCase() + str[str.length - 1].substring(1) + " ");
        for (int i = str.length - 2; i > 0; i--) {
            out.print(str[i] + " ");
        }
        out.print(str[0].substring(0, 1).toLowerCase() + str[0].substring(1));
        /*
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append(str[str.length - 1].toLowerCase());
        strBuffer.setCharAt(0, toUpperCase(strBuffer.charAt(0)));
        for (int i = str.length - 2; i >= 0; i--) {
            strBuffer.append(" " + str[i].toLowerCase());
        }
        out.print("The resulting string: " + strBuffer);
        */
    }

}