package arrays.Task1.classes.Task11;

import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Percy", "Jackson", 18, 400),
                new Student("Luca", "Patterson", 19, 400),
                new Student("Usman", "Carter", 18, 350),
                new Student("Griffin", "Patter", 20, 800),
                new Student("Cannon", "Price", 22, 500),
                new Student("Landen", "Simmons", 19, 450),
                new Student("Umer", "Thompson", 24, 600),
                new Student("Uriyah", "Price", 20, 750),
                new Student("Boston", "Rivera", 21, 520),
                new Student("Leighton", "Carter", 23, 490));

        printSortBy("name", students, Comparator
                .comparing(Student::getLastName)
                .thenComparing(Student::getFirstName));
        printSortBy("age", students, Comparator.comparing(Student::getAge));
        printSortBy("salary", students, Comparator.comparing(Student::getSalary));
        printSortBy("age, salary and name", students, Comparator.comparing(Student::getAge)
                .thenComparing(Student::getSalary)
                .thenComparing(Student::getLastName)
                .thenComparing(Student::getFirstName));
    }

    private static void printSortBy(String param, List<? extends Student> students, Comparator comparator) {
        out.println("\tList of students sorted by " + param + ": ");
        students.stream()
                .sorted(comparator)
                .forEach(element -> ((Student) element).display());
    }

}