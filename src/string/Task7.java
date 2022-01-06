package string;

import java.util.Scanner;

import static java.lang.System.out;

public class Task7 {
    public static void main(String[] args) {
        StringBuffer strBuffer = new StringBuffer();
        boolean addSpace = true;
        Scanner console = new Scanner(System.in);

        out.print("Enter your line: ");
        char[] str = console.nextLine().toCharArray();

        //Видалення всіх символів з рядка крім чисел та пробілів
        final char[] numbers = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (char c : str) {
            for (char number : numbers) {
                if (c == number) {
                    strBuffer.append(c);
                    addSpace = false;
                }
            }
            if (addSpace)
                strBuffer.append(" ");
            addSpace = true;
        }

        //Обрахунок результату
        int result = 0;
        for (String n : strBuffer.toString().split(" ")) {
            if (!n.isEmpty()) {
                result += Integer.parseInt(n);
            }
        }

        out.print("The sum of the line numbers = " + result);
    }
}
