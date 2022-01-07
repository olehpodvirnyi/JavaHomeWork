package classes;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.System.out;

public class Task11 {
    static class Student {
        private String firstName;
        private String lastName;
        private int age;
        private float salary;

        Student() {
            this.firstName = "";
            this.lastName = "";
            this.age = 0;
            this.salary = 0.0f;
        }

        Student(String firstName, String lastName, int age, float salary) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.salary = salary;
        }

        public void display() {
            out.println(this.getFirstName() + " " + this.getLastName() + "\tage: " + this.getAge() + ", salary: " +
                    this.getSalary());
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public float getSalary() {
            return salary;
        }

        public void setSalary(float salary) {
            this.salary = salary;
        }
    }

    public static void main(String[] args) {
        Student[] students = new Student[]{
                new Student("Percy", "Jackson", 18, 400),
                new Student("Luca", "Patterson", 19, 400),
                new Student("Usman", "Carter", 18, 350),
                new Student("Griffin", "Patter", 20, 800),
                new Student("Cannon", "Price", 22, 500),
                new Student("Landen", "Simmons", 19, 450),
                new Student("Umer", "Thompson", 24, 600),
                new Student("Uriyah", "Price", 20, 750),
                new Student("Boston", "Rivera", 21, 520),
                new Student("Leighton", "Carter", 23, 490),
        };
        out.println("\tList of students sorted by name:");
        Arrays.stream(students)
                .sorted(Comparator
                        .comparing(Student::getLastName)
                        .thenComparing(Student::getFirstName))
                .forEach(Student::display);
        out.println("\n\tList of students sorted by age");
        Arrays.stream(students)
                .sorted(Comparator.comparing(Student::getAge))
                .forEach(Student::display);
        out.println("\n\tList of students sorted by salary");
        Arrays.stream(students)
                .sorted(Comparator.comparing(Student::getSalary))
                .forEach(Student::display);
        out.println("\n\tList of students sorted by age, salary and name");
        Arrays.stream(students)
                .sorted(Comparator.comparing(Student::getAge)
                        .thenComparing(Student::getSalary)
                        .thenComparing(Student::getLastName)
                        .thenComparing(Student::getFirstName))
                .forEach(Student::display);
    }
}