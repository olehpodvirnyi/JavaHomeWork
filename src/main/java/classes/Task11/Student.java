package classes.Task11;

import static java.lang.System.out;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private float salary;

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

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public float getSalary() {
        return salary;
    }

}